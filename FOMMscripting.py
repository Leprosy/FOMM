import cfg


class Interpreter:
    def __init__(self):
        cfg.debug("Creating interpreter instance..")
        self.version = "0.1"

    def eval(self, inst, window):
        if inst["event"] == 'alert':
            window.message = inst["data"]["msg"]
            window.status = cfg._IN_GAME_ALERT
        elif inst["event"] == 'prompt':
            window.message = inst["data"]["msg"]
            window.status = cfg._IN_GAME_ALERT
        elif inst["event"] == 'teleport':
            window.party.go_to(inst["data"]["x"], inst["data"]["y"])
            window.need_update = True
        elif inst["event"] == 'teleport_map':
            window.load_map(inst["data"]["map"], inst["data"]["x"], inst["data"]["y"])
        else:
            cfg.error("Attempting to run an undefined event")
