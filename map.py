import pyglet
import main.Game as Game
import json


class Map:
    def __init__(self, filename):
        data = open(filename).read()
        data = json.loads(data)
        self.name = data["name"]
        self.tiles = []

        print Game.getcfg()

        #Definitions
        self.defs = json.loads(open())

        for i in range(0, len(data["floor"])):
            aux = []

            for j in range(0, len(data["floor"][i])):
                aux.append(Tile(data["floor"][i][j], data["thing"][i][j]))

            self.tiles.append(aux)

    def render(self):
        size = 64

        for i in range(0, len(self.tiles)):
            for j in range(0, len(self.tiles[i])):
                pyglet.text.Label("<%s>" % self.tiles[i][j].thing,
                          font_name="Arial",
                          font_size=8,
                          x=j * size, y=i * size,
                          anchor_x="center", anchor_y="center").draw()

                b = self.tiles[i][j].floor
                pyglet.graphics.draw(4, pyglet.gl.GL_POLYGON,
                                    ('v2i', (j * size, i * size,
                                    (j + 1) * size, i * size,
                                    (j + 1) * size, (i + 1) * size,
                                    j * size, (i + 1) * size)),
                                    ('c3B', (
                                    60 * b, 200, 10,
                                    60 * b, 200, 10,
                                    60 * b, 200, 10,
                                    60 * b, 200, 10))
                                    )


class Tile:
    def __init__(self, floor, thing):
        self.floor = floor
        self.thing = thing