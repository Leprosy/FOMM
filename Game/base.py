import pyglet
from pyglet.window import mouse, key
from Game.classes import *


class Game(pyglet.window.Window):
    def __init__(self, config):
        super(Game, self).__init__(800, 600, caption=config['title'],
                                   vsync=False)

        #Environment setup
        self.config_data = config
        pyglet.resource.path = [self.config_data['game_res'],
                                self.config_data['game_res'] + '/img',
                                self.config_data['game_res'] + '/snd']
        pyglet.resource.reindex()

        self.set_icon(pyglet.resource.image('icon16.png'),
                      pyglet.resource.image('icon32.png'),
                      pyglet.resource.image('icon64.png'),
                      pyglet.resource.image('icon128.png'))

        #Global attributes
        self.inGame = False
        self.clock = pyglet.clock.ClockDisplay()
        self.map = None
        self.party = {"x": 0, "y": 0}

    def init_game(self):
        #Load or start a new one?
        self.map = Map(self.config_data['game_res'] + '/maps/map1.json')

        print self.map.data["name"]
        print self.map.data["floor"]

    def draw_gameGUI(self):
        self.clock.draw()

    def draw_mainmenu(self):
        pyglet.text.Label("FOMM",
                          font_name='Arial',
                          font_size=32,
                          x=100, y=300,
                          anchor_x='left', anchor_y='center').draw()
        pyglet.text.Label("< Press Spacebar to start >",
                          font_name='Arial',
                          font_size=14,
                          x=100, y=250,
                          anchor_x='left', anchor_y='center').draw()
        pyglet.text.Label("< Press ESC to exit >",
                          font_name='Arial',
                          font_size=14,
                          x=100, y=230,
                          anchor_x='left', anchor_y='center').draw()

    def update(self, secs):
        #Clear window
        self.clear()

        if self.inGame:
            #Game logic
            pass
        else:
            #Main menu
            self.draw_mainmenu()

    #Events handlers
    def on_mouse_motion(self, x, y, dx, dy):
        self.x = x
        self.y = y

    def on_mouse_press(self, x, y, button, modifiers):
        #In game mouse clicks
        if self.inGame:
            #Game logic
            pass

    def on_key_press(self, symbol, mod):
        #Main menu keys
        if self.inGame is False:
            if symbol == key.SPACE:
                self.init_game()
            if symbol == key.ESCAPE:
                quit()

        #In game keys
        else:
            #Game logic
            pass

    #Starts
    def game_start(self):
        pyglet.clock.schedule_interval(self.update, 1 / 60.0)
        pyglet.app.run()
