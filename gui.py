import pyglet
import cfg


class Gui:
    def __init__(self, window):
        self.window = window
        self.main_menu = None

    def alert(self, string):
        cfg.debug("gui.alert:%s" % string)

#        pyglet.text.Label(string + " (Press ESC)",
#                          font_name="Arial",
#                          font_size=12,
#                          x=cfg.resolution[0] / 2,
#                          y=cfg.resolution[1] / 2,
#                          anchor_x="center", anchor_y="center").draw()

        frame = Frame(Theme('res/gui'),
                      w=cfg.resolution[0],
                      h=cfg.resolution[1])
        dia = Dialogue('', x=500, y=550, content=
                       FlowLayout(w=250, children=[Label(string),
                                                   Button('OK', action=self.window.button_action)]))

        frame.add(dia)
        self.window.push_handlers(frame)
        self.window.dialogs.append(frame)

    def draw_gui(self):
        pyglet.text.Label("Party = %d, %d"
                           % (self.window.party.x, self.window.party.y),
              font_name="Arial",
              font_size=8,
              x=50, y=500,
              anchor_x="left", anchor_y="top").draw()

    def draw_mainmenu(self):
        if self.main_menu is None:
            self.main_menu = pyglet.resource.image('gui/title.png')

        self.main_menu.blit(0, 0)

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
