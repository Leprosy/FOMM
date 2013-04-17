import pyglet
import json
import cfg


class Map:
    def __init__(self, filename, window):
        data = open(filename).read()
        data = json.loads(data)
        self.window = window
        self.name = data["name"]
        self.tiles = []
        self.script = data["script"]
        self.scr_line = 0
        self.scr_coord = None

        #Definitions
        self.defs = json.load(open(filename))

        for i in range(0, len(data["floor"])):
            aux = []

            for j in range(0, len(data["floor"][i])):
                aux.append(Tile(data["floor"][i][j], data["thing"][i][j], i, j))

            self.tiles.append(aux)

    def render(self):
        for i in range(0, len(self.tiles)):
            for j in range(0, len(self.tiles[i])):
                self.tiles[i][j].render()

    def run_script(self, coord):
        if coord in self.script:
            if coord != self.scr_coord:
                self.scr_line = 0
                self.scr_coord = coord

            script = self.script[coord]

            if self.scr_line <= len(script) - 1:
                inst = script[self.scr_line]
                print "executing %d => %s" % (self.scr_line, inst)

                if inst["event"] == 'alert':
                    self.window.message = inst["data"]["msg"]
                    self.window.status = cfg._IN_GAME_ALERT
                else:
                    print "undefined_event"

                self.scr_line += 1
        else:
            self.scr_line = 0


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
        i = self.x
        j = self.y

        self.sprites["floors"][self.floor].x = j * cfg.size
        self.sprites["floors"][self.floor].y = i * cfg.size
        self.sprites["floors"][self.floor].draw()

        pyglet.text.Label("<%s>" % self.defs["floors"][self.floor]["name"],
                  font_name="Arial",
                  font_size=8,
                  x=j * cfg.size + cfg.size / 2,
                  y=i * cfg.size + cfg.size / 2,
                  anchor_x="center", anchor_y="center").draw()
