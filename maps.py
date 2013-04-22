import pyglet
import json
import cfg
import random
import FOMMscripting


class Map:
    def __init__(self, filename, window):
        cfg.debug("Opening %s map..." % filename)
        data = json.load(open(filename))
        self.__dict__ = data

        self.window = window
        self.tiles = []
        self.scr_line = 0
        self.scr_coord = None
        self.music_player = None
        self.interpreter = FOMMscripting.Interpreter()

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
                cfg.debug("Executing %s, line %d" % (inst, self.scr_line))

                #Events interpreter
                self.interpreter.eval(inst, self.window)
                self.scr_line += 1
        else:
            self.scr_line = 0

    def check_music(self):
        if self.music_player is None or self.music_player.time == 0.0:
            resource = cfg.game_res + '/snd/mus/%s.mp3' % random.choice(self.music)
            self.music_player = pyglet.media.load(resource).play()

    def stop_music(self):
        self.music_player.stop()

    def get_tile(self, x, y):
        return self.tiles[y][x]

    def get_height(self):
        return len(self.tiles)

    def get_width(self):
        return len(self.tiles[0])


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
        cfg.debug("Loading %s floor img" % f["name"])
        img = pyglet.resource.image(cfg.game_res + '/img/floors/%s.png'
                                    % f["name"])
        sprites["floors"].append(pyglet.sprite.Sprite(img))
    for f in defs["things"]:
        cfg.debug("Loading %s thing img" % f["name"])
        img = pyglet.resource.image(cfg.game_res + '/img/things/%s.png'
                                    % f["name"])
        sprites["things"].append(pyglet.sprite.Sprite(img))

    def __init__(self, floor, thing, x, y):
        self.floor = floor
        self.thing = thing
        self.x = x
        self.y = y

    def render(self):
        i = self.x
        j = self.y

        #Draw tile: Floor + Thing
        self.sprites["floors"][self.floor].x = j * cfg.size
        self.sprites["floors"][self.floor].y = i * cfg.size
        self.sprites["floors"][self.floor].draw()

        if self.thing > 0:
            self.sprites["things"][self.thing - 1].x = j * cfg.size
            self.sprites["things"][self.thing - 1].y = i * cfg.size
            self.sprites["things"][self.thing - 1].draw()

    def get_floor_data(self):
        return self.defs["floors"][self.floor]

    def get_thing_data(self):
        return self.defs["things"][self.thing - 1]
