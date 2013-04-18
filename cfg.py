import time

#Config parameters
version = "0.1"
game_res = "res"
title = "FOMM"
resolution = [800, 600]
size = 64

#Constants
_IN_MAINMENU = 0
_IN_GAME = 1
_IN_GAME_ALERT = 2
_IN_GAME_DIALOG = 3


def debug(string):
    print "[%s] - %s" % (time.asctime(), string)


def error(string):
    print "[%s] - ERROR : %s" % (time.asctime(), string)
