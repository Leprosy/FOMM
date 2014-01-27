define(['game/monster', 'game/player'], function(Monster, Player) {
    var Main = {};

    Main.init = function() {
        var P = new Player('Sir Lepro');
        var M = new Monster('Dragon');
        console.log(P, M, M.hit());
        console.log('init');
    };

    return Main;
});
