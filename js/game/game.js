var Game = Game || {};

/* Items */
Game.map = false;
Game.player = false;
Game.play = false;

/* Methods */
Game.loadPlayer = function() {
    $.get('backend/player.php', function(data) {
        Game.player = JSON.parse(data);
    });
};

Game.loadMap = function() {
    $.get('backend/map.php', function(data) {
        Game.map = JSON.parse(data);
        Canvas.loadMap(Game.map);
    });
};

Game.start = function() {
    if (!Game.player || !Game.map) {
        alert('Load a map & login as a player');
        return false;
    }

    Game.play = true;

    /* Keyboard bind*/
    $(document).keydown(function(ev) {
        switch (ev.keyCode) {
            case 38:
                Game.forward();
                break;
            case 40:
                Game.back();
                break;
            case 37:
                Game.rotateLeft();
                break;
            case 39:
                Game.rotateRight();
                break;
        }
    });

    /* Elements in their spots */
    Game.player.x = Game.map.start[0];
    Game.player.y = Game.map.start[1];

    /* 3d world ready */
    Canvas.animate();
}

Game.end = function() {
    /* Keyboard unbind */
    $(document).unbind('keydown')
    Game.play = false;
}



/* Player movement */
Game.forward = function() {
    Game._move(1);
}
Game.back = function() {
    Game._move(-1);
}
Game._move = function(inc) {
    var oldX = Game.player.x;
    var oldY = Game.player.y;

    // Calculate increment
    switch(Game.player.direction) {
        case 0:
            oldY += inc;
            break;
        case 1:
            oldX += inc;
            break;
        case 2:
            oldY -= inc;
            break;
        case 3:
            oldX -= inc;
            break;
    }

    // Walls are impassable (@todo replace with flag)
    if (Game.map.tiles[oldY][oldX] == 0) {
        Game.player.x = oldX;
        Game.player.y = oldY;
    }
}
Game.rotateLeft = function() {
    Game.player.direction--; if (Game.player.direction < 0) Game.player.direction = 3;
}
Game.rotateRight = function() {
    Game.player.direction++; if (Game.player.direction > 3) Game.player.direction = 0;
}