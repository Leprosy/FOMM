import pyglet
import cfg
import maps
import player
import gui
import random
from pyglet.window import mouse, key


class Game(pyglet.window.Window):
    '''
    Main definitions and elements for the game
    '''
    def __init__(self):
        super(Game, self).__init__(cfg.resolution[0], cfg.resolution[1],
                                   caption=cfg.title, vsync=False)
        #Environment setup
        cfg.debug("Initializing environment")
        pyglet.resource.path = [cfg.game_res]
        pyglet.resource.reindex()
        random.seed()

        #Global attributes
        cfg.debug("Initializing basic objects")
        self.status = cfg._IN_MAINMENU
        self.message = None
        self.need_update = True
        self.map = None
        self.gui = gui.Gui(self)
        self.party = player.Party(1, 5, self)

    def init_game(self):
        cfg.debug("Init game")

        #Load or start a new one?        
        self.map = maps.Map(cfg.game_res + '/maps/map1.json', self)

        #Start
        self.status = cfg._IN_GAME

    def update(self, secs):
        if self.status == cfg._IN_MAINMENU:
            #Clear window
            self.clear()

            #Main menu
            self.gui.draw_mainmenu()
        else:
            if self.need_update:
                cfg.debug("Status updated...")
                #Clear window
                self.clear()

                self.need_update = False
                #Game logic
                #Map render
                self.map.render()
                #Monsters
                #Party
                self.party.render()
                #gui
                self.gui.draw_gui()

                #scripts in map
                script_coord = "%d,%d" % (self.party.x, self.party.y)
                self.map.run_script(script_coord)

                #alerts, messages, prompts and other user interactions
                if self.status == cfg._IN_GAME_ALERT:
                    self.gui.alert(self.message)

    '''
    Event handlers
    '''
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

    #Starts
    def game_start(self):
        pyglet.clock.schedule_interval(self.update, 1 / 60.0)
        pyglet.app.run()

##check events -> window.push_handlers(pyglet.window.event.WindowEventLogger())

'''
Begin the game...
'''
if __name__ == '__main__':
    cfg.debug("Initializing game")
    G = Game()
    G.game_start()
