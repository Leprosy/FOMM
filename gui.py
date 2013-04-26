import pyglet
import cfg


class Gui:
    def __init__(self, window):
        self.window = window
        self.main_window = None

    def alert(self, string):
        cfg.debug("gui.alert:%s" % string)

        pyglet.text.Label(string + " (Press ESC)",
                          font_name="Arial",
                          font_size=12,
                          x=cfg.resolution[0] / 2,
                          y=cfg.resolution[1] / 2,
                          anchor_x="center", anchor_y="center").draw()

    def draw_gui(self):
        if self.main_window is None:
            self.main_window = pyglet.resource.image('gui/gui.png')

        self.main_window.blit(0, 0)

    def draw_mainmenu(self):
        if self.main_window is None:
            self.main_window = pyglet.resource.image('gui/title.png')

        self.main_window.blit(0, 0)

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
