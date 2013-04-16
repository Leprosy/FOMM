import pyglet
import json
import cfg


class Party:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.items = []
        self.food = 20

    def render(self):
        pyglet.text.Label("1P",
                          font_name="Arial",
                          font_size=8,
                          x=self.x * cfg.size + cfg.size / 2,
                          y=self.y * cfg.size + cfg.size / 2,
                          anchor_x="center", anchor_y="center").draw()
