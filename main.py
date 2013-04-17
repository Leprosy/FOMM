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
        pyglet.resource.path = [cfg.game_res]
        pyglet.resource.reindex()
        random.seed()

        #Global attributes
        self.status = cfg._IN_MAINMENU
        self.message = None
        self.need_update = True
        self.map = None
        self.gui = gui.Gui(self)
        self.party = player.Party(0, 0)

    def init_game(self):
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
                print "updating game"
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
                quit()
        else:
            #In game keys
            if self.status == cfg._IN_GAME:
                self.need_update = True

                if symbol == key.UP:
                    self.party.y += 1
                if symbol == key.DOWN:
                    self.party.y -= 1
                if symbol == key.LEFT:
                    self.party.x -= 1
                if symbol == key.RIGHT:
                    self.party.x += 1
                if symbol == key.ESCAPE:
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
    G = Game()
    G.game_start()
