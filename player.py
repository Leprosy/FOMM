import pyglet
import json
import cfg


class Party:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.angle = 0
        self.items = []
        self.food = 20

    def render(self):
        angle = ["^", ">", "v", "<"]
        pyglet.text.Label("1P %s" % angle[self.angle],
                          font_name="Arial",
                          font_size=8,
                          x=self.x * cfg.size + cfg.size / 2,
                          y=self.y * cfg.size + cfg.size / 2,
                          anchor_x="center", anchor_y="center").draw()

    def up(self):
        self.y -= 1

    def down(self):
        self.y += 1

    def left(self):
        self.x -= 1

    def right(self):
        self.x += 1

    def rotate_right(self):
        self.angle += 1
        self.angle = self.angle % 4

    def rotate_left(self):
        self.angle -= 1
        self.angle = self.angle % 4
