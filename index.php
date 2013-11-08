<html>
    <head>
        <title>game</title>
        <style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
    display: block;
}
body {
    line-height: 1;
}
ol, ul {
    list-style: none;
}
blockquote, q {
    quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
    content: '';
    content: none;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
}


#gui {
    width: 960px;
    height: 600px;
    margin-left: auto;
    margin-right: auto;
    border: 1px solid #000;
}
#gui #viewport {
    width: 80%;
    height: 100%;
    background-color: #000;
    float: left;
}
#gui #interface {
    background-color: #ccc;
    width: 20%;
    height: 100%;
    float: left;
}

        </style>
    </head>

    <body>

        <div id="gui">
            <div id="viewport">
            </div>

            <div id="interface">
            	<li><a href="javascript:Game.loadPlayer()">Load player</a></li>
            	<li><a href="javascript:Game.loadMap()">Load map</a></li>
            	<li><a href="javascript:Game.start()">Enter Dungeon!</a></li>
            </div>
        </div>

        <!-- Scripts -->
        <!-- 3D -->
        <script src="js/jquery.js"></script>
        <script src="js/three/build/three.min.js"></script>

        <!-- Game -->
        <script src="js/game/game.js"></script>
        <script src="js/game/canvas.js"></script>

        <!-- Audio  -->
        <script src="http://code.createjs.com/soundjs-0.5.0.min.js"></script>

        <script>
            Canvas.init();
        </script>
    </body>
</html>