define(function() {

    var Monster = function(name) {
        this.name = name;
        this.hp = 4000;
        this.gold = 2000;
    };

    Monster.prototype.hit = function() {
        return Math.round(Math.random() * 20);
    };

    return Monster;
});
