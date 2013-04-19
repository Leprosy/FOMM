import pyglet
import json
import cfg


class Party:
    def __init__(self, x, y, window):
        self.window = window

        self.x = x
        self.y = y
        self.new_x = x
        self.new_y = y

        self.angle = 0
        self.items = []

        self.food = 20
        self.gold = 2000

        self.characters = []

    def init_chars(self, filename):
        cfg.debug("Opening %s party definition..." % filename)
        data = json.load(open(filename))

        self.characters = []

        for char in data:
            self.characters.append(Character(char))

    def render(self):
        angle = ["^", ">", "v", "<"]
        pyglet.text.Label("1P %s" % angle[self.angle],
                          font_name="Arial",
                          font_size=8,
                          x=self.x * cfg.size + cfg.size / 2,
                          y=self.y * cfg.size + cfg.size / 2,
                          anchor_x="center", anchor_y="center").draw()

    def up(self):
        self.new_y = self.y - 1
        self.check_movement()

    def down(self):
        self.new_y = self.y + 1
        self.check_movement()

    def left(self):
        self.new_x = self.x - 1
        self.check_movement()

    def right(self):
        self.new_x = self.x + 1
        self.check_movement()

    def rotate_right(self):
        self.angle += 1
        self.angle = self.angle % 4

    def rotate_left(self):
        self.angle -= 1
        self.angle = self.angle % 4

    def go_to(self, x, y):
        self.new_x = x
        self.new_y = y
        self.check_movement()

    def check_movement(self):
        wmap = self.window.map

        #Boundaries of the map
        if self.new_x < 0:
            self.new_x = 0
        if self.new_y < 0:
            self.new_y = 0

        if self.new_x > self.window.map.get_width() - 1:
            self.new_x = self.window.map.get_width() - 1
        if self.new_y > self.window.map.get_height() - 1:
            self.new_y = self.window.map.get_height() - 1

        floor = wmap.get_tile(self.new_x, self.new_y).get_floor_data()
        thing = wmap.get_tile(self.new_x, self.new_y).get_thing_data()

        #Geo of the new tile
        if "impassable" in floor and floor["impassable"] == True:
            self.new_x = self.x
            self.new_y = self.y
        if "impassable" in thing and thing["impassable"] == True:
            self.new_x = self.x
            self.new_y = self.y

        #Set the new position
        self.x = self.new_x
        self.y = self.new_y


class Character:
    def __init__(self, data):
        self.__dict__ = data
        cfg.debug("Welcome %s" % self.name)
