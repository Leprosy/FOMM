requirejs.config({});
/* requirejs.onError = function (err) {
    console.error("FATAL ERROR", err);
}; */

// Start the main app logic.
requirejs(['game/main', 'jquery'], function (Main) {
    Main.init();
    $('#debug').html('Loaded');
});
