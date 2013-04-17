import pyglet
import cfg


class Gui:
    def __init__(self, window):
        self.window = window

    def alert(self, string):
        print "Utils.alert - %s" % string
        pyglet.text.Label(string,
                          font_name="Arial",
                          font_size=12,
                          x=cfg.size / 2,
                          y=cfg.size / 2,
                          anchor_x="center", anchor_y="center").draw()

    def draw_gui(self):
        pyglet.text.Label("Party = %d, %d"
                           % (self.window.party.x, self.window.party.y),
              font_name="Arial",
              font_size=8,
              x=50, y=500,
              anchor_x="right", anchor_y="top").draw()

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
