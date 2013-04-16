import pyglet
import json
import cfg


class Map:
    def __init__(self, filename):
        data = open(filename).read()
        data = json.loads(data)
        self.name = data["name"]
        self.tiles = []

        #Definitions
        self.defs = json.load(open(filename))

        for i in range(0, len(data["floor"])):
            aux = []

            for j in range(0, len(data["floor"][i])):
                aux.append(Tile(data["floor"][i][j], data["thing"][i][j], i, j))

            self.tiles.append(aux)

    def render(self):
        size = 64

        for i in range(0, len(self.tiles)):
            for j in range(0, len(self.tiles[i])):
                self.tiles[i][j].render()


class Tile:
    defs = {
        "floors": json.load(open(cfg.game_res + '/defs/floors.json')),
        "things": json.load(open(cfg.game_res + '/defs/things.json')),
    }
    sprites = {
        "floors": [],
        "things": []
    }

    #init code
    for f in defs["floors"]:
        img = pyglet.resource.image(cfg.game_res + '/img/floors/%s.png'
                                    % f["name"])
        sprites["floors"].append(pyglet.sprite.Sprite(img))

    def __init__(self, floor, thing, x, y):
        self.floor = floor
        self.thing = thing
        self.x = x
        self.y = y

    def render(self):
        size = 64

        i = self.x
        j = self.y

        self.sprites["floors"][self.floor].x = i * size
        self.sprites["floors"][self.floor].y = j * size
        self.sprites["floors"][self.floor].draw()

        pyglet.text.Label("<%s>" % self.defs["things"][self.thing]["name"],
                  font_name="Arial",
                  font_size=8,
                  x=j * size, y=i * size,
                  anchor_x="center", anchor_y="center").draw()