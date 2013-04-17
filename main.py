import pyglet
import cfg
import maps
import player
import gui
from pyglet.window import mouse, key


class Game(pyglet.window.Window):
    '''
    Main definitions and elements for the game
    '''
    def __init__(self):
        super(Game, self).__init__(cfg.res[0], cfg.res[1],
                                   caption=cfg.title, vsync=False)
        #Environment setup
        pyglet.resource.path = [cfg.game_res]
        pyglet.resource.reindex()

        #Global attributes
        self.inGame = False
        self.inDialog = False
        self.map = None
        self.gui = gui.Gui(self)
        self.party = player.Party(0, 0)

    def init_game(self):
        #Load or start a new one?
        self.map = maps.Map(cfg.game_res + '/maps/map1.json')

        #Start
        self.inGame = True

    def update(self, secs):
        #Clear window
        self.clear()

        if self.inGame:
            #Game logic
            #Map render
            self.map.render()
            #Monsters
            #Party
            self.party.render()
            #gui
            self.gui.draw_gui()

        else:
            #Main menu
            self.gui.draw_mainmenu()

    '''
    Event handlers
    '''
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
            #Party movement
            if symbol == key.UP:
                self.party.y += 1
            if symbol == key.DOWN:
                self.party.y -= 1
            if symbol == key.LEFT:
                self.party.x -= 1
            if symbol == key.RIGHT:
                self.party.x += 1
            if symbol == key.SPACE:
                self.utils.alert("FUCK IT's A SPACE bAr!!!")

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