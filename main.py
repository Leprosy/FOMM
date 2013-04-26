import pyglet
from pyglet.gl import *
import cfg

#init alpha and resources
pyglet.resource.path = [cfg.game_res]
pyglet.resource.reindex()
glEnable(GL_BLEND)
glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)

import maps
import player
import gui
import random
from pyglet.window import mouse, key
from simplui import *


class Game(pyglet.window.Window):
    '''
    Main definitions and elements for the game
    '''
    def __init__(self):
        super(Game, self).__init__(cfg.resolution[0], cfg.resolution[1],
                                   caption=cfg.title, vsync=False)
        #Environment setup
        cfg.debug("Initializing environment")
        random.seed()

        #Global attributes
        cfg.debug("Initializing basic objects")
        self.status = cfg._IN_MAINMENU
        self.message = None
        self.need_update = True
        self.map = None
        self.party = None
        self.gui = gui.Gui(self)
        self.dialogs = []

        #Main menu
        self.main_menu = None

    def init_game(self):
        #Load or start a new one?
        #New game
        cfg.debug("Starting a new game...")
        self.map = maps.Map('map1', self)
        self.party = player.Party(1, 5, self)
        self.party.init_chars(cfg.game_res + '/defs/defparty.json')

        #Start
        self.status = cfg._IN_GAME

    def update(self, secs):
        if self.status == cfg._IN_MAINMENU:
            #Clear window
            self.clear()

            #Main menu
            self.gui.draw_mainmenu()
        else:
            #Clear window
            self.clear()

            #Map render
            self.map.render()
            self.map.check_music()

            #Party
            self.party.render()

            #Gui
            self.gui.draw_gui()

            if len(self.dialogs) > 0:
                for frame in self.dialogs:
                    frame.draw()

            if self.need_update:
                cfg.debug("Status updated...")

                self.need_update = False
                #Game logic
                #Monsters

                #scripts in map
                script_coord = "%d,%d" % (self.party.x, self.party.y)
                self.map.run_script(script_coord)

                #alerts, messages, prompts and other user interactions
                if self.status == cfg._IN_GAME_ALERT:
                    self.gui.alert(self.message)

    '''
    Event handlers
    '''
    def button_action(self, button):
        self.dialogs.pop()
        self.status = cfg._IN_GAME
        self.need_update = True

    def on_mouse_motion(self, x, y, dx, dy):
        self.x = x
        self.y = y

    def on_mouse_press(self, x, y, button, modifiers):
        #In game mouse clicks
        if self.status == cfg._IN_GAME:
            #Game logic
            pass

    def on_key_press(self, symbol, mod):
        #Main menu keys
        if self.status == cfg._IN_MAINMENU:
            if symbol == key.SPACE:
                self.gui.main_window = None
                self.init_game()
            if symbol == key.ESCAPE:
                cfg.debug("We will leave from FOMM now. Cheers!")
                quit()
        else:
            #In game keys
            if self.status == cfg._IN_GAME:
                self.need_update = True

                if symbol == key.NUM_8:
                    self.party.down()
                if symbol == key.NUM_2:
                    self.party.up()
                if symbol == key.NUM_4:
                    self.party.left()
                if symbol == key.NUM_6:
                    self.party.right()
                if symbol == key.NUM_7:
                    self.party.rotate_left()
                if symbol == key.NUM_9:
                    self.party.rotate_right()
                if symbol == key.ESCAPE:
                    cfg.debug("Leaving FOMM now. Bye")
                    quit()

            if self.status == cfg._IN_GAME_ALERT:
                if symbol == key.ESCAPE:
                    self.need_update = True
                    self.status = cfg._IN_GAME

    '''
    Functions
    '''
    def load_map(self, mapname, x, y):
        self.map.stop_music()
        self.map = maps.Map('%s/maps/%s.json' % (cfg.game_res, mapname), self)
        self.party.go_to(x, y)
        self.need_update = True

    '''
    Starts
    '''
    def game_start(self):
        pyglet.clock.schedule_interval(self.update, 1 / 60.0)
        pyglet.app.run()

##check events -> window.push_handlers(pyglet.window.event.WindowEventLogger())

'''
Begin the game...
'''
if __name__ == '__main__':
    G = Game()
    cfg.debug("Firing up the game")
    G.game_start()
