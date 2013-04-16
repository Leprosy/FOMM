import pyglet
import cfg
import maps
import player
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
        self.map = None
        self.party = player.Party(0, 0)

    def init_game(self):
        #Load or start a new one?
        self.map = maps.Map(cfg.game_res + '/maps/map1.json')

        #Start
        self.inGame = True

    def draw_gameGUI(self):
        #self.clock.draw()
        pass

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
            #Map render
            self.map.render()
            #Monsters
            #Party
            self.party.render()
            #gui
            pyglet.text.Label("Party = %d, %d" % (self.party.x, self.party.y),
                  font_name="Arial",
                  font_size=8,
                  x=50, y=500,
                  anchor_x="right", anchor_y="top").draw()
        else:
            #Main menu
            self.draw_mainmenu()

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
