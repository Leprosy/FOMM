var Canvas = {};

// Constants
Canvas.WIDTH = 768;
Canvas.HEIGHT = 600;
Canvas.VIEW_ANGLE = 45;
Canvas.ASPECT = Canvas.WIDTH / Canvas.HEIGHT;
Canvas.NEAR = 0.1;
Canvas.FAR = 10000;
Canvas.step = 50;

Canvas.init = function() {
    /* Create a WebGL renderer, camera and a scene */
    var $container = $('#viewport');
    var scene = new THREE.Scene();
    var camera = new THREE.PerspectiveCamera(
                                Canvas.VIEW_ANGLE,
                                Canvas.ASPECT,
                                Canvas.NEAR,
                                Canvas.FAR);

    var renderer = new THREE.WebGLRenderer();

    renderer.setClearColor(0x000000, 1);
    scene.add(camera);
    renderer.setSize(Canvas.WIDTH, Canvas.HEIGHT);
    $container.append(renderer.domElement);    
    
    var light = new THREE.PointLight(0xFFFFFF, 3, 400);
    scene.add(light);

    // Assign
    Canvas.camera = camera;
    Canvas.scene = scene;
    Canvas.light = light;
    Canvas.renderer = renderer;
}


// draw functions
Canvas.animate = function() {
    if (Game.play) {
        requestAnimationFrame(Canvas.animate);
    }

    // Elements update
    Canvas.update();

    // Render scene
    Canvas.render();
}

Canvas.update = function() {
    /* Camera rotation */
    Canvas.camera.rotation.y = -Game.player.direction * (Math.PI / 2);

    /* Camera position => Player */
    Canvas.camera.position.x = Game.player.x * Canvas.step;
    Canvas.camera.position.z = -Game.player.y * Canvas.step;
    Canvas.light.position = Canvas.camera.position;

    /* Translation for vision */
    Canvas.camera.translateZ(50);
}

Canvas.render = function() {
    Canvas.renderer.render(Canvas.scene, Canvas.camera);
}

Canvas.loadMap = function(map) {
    /* Textures & Objects */
    var txts = [new THREE.ImageUtils.loadTexture('img/txts/cave1.jpg'),
                new THREE.ImageUtils.loadTexture('img/txts/cave2.jpg'),
                new THREE.ImageUtils.loadTexture('img/txts/floor1.jpg'),
                new THREE.ImageUtils.loadTexture('img/txts/floor2.jpg')];

    var objs = [new THREE.ImageUtils.loadTexture('img/obj/tree.png'),
                new THREE.ImageUtils.loadTexture('img/obj/tree2.png')];

    /* Load a 3D map and make the meshes & sprites */ 
    for (i = 0; i < map.tiles.length; ++i) {
        for (j = 0; j < map.tiles[i].length; ++j) {

            /* Walls */
            if (map.tiles[i][j] != 0) {
                var material = new THREE.MeshLambertMaterial({
                    map: txts[map.tiles[i][j] - 1]
                });
                var geo = new THREE.CubeGeometry(Canvas.step, Canvas.step, Canvas.step);
                var mesh1 = new THREE.Mesh(geo, material);

                mesh1.position.x = j * Canvas.step;
                mesh1.position.z = i * Canvas.step * -1;
                mesh1.position.y = 0;

                // Add the meshes to the scene
                Canvas.scene.add(mesh1);
            } else {
                //Floor & ceiling
                var material1 = new THREE.MeshLambertMaterial({ map: txts[2] });
                var material2 = new THREE.MeshLambertMaterial({ map: txts[3] });
                var geo = new THREE.CubeGeometry(Canvas.step, Canvas.step / 10, Canvas.step);
                var mesh1 = new THREE.Mesh(geo, material1);
                var mesh2 = new THREE.Mesh(geo, material2);
                mesh1.position.x = j * Canvas.step;
                mesh1.position.z = i * Canvas.step * -1;
                mesh1.position.y = Canvas.step / -2;
                mesh2.position = mesh1.position.clone();
                mesh2.position.y = Canvas.step / 2;

                Canvas.scene.add(mesh1);
                Canvas.scene.add(mesh2);
            }

            /* Objects */
            if (map.objects[i][j] != 0) {
                var material = new THREE.SpriteMaterial({
                    map: objs[map.objects[i][j] - 1],
                    useScreenCoordinates: false,
                    alignment: THREE.SpriteAlignment.center
                });
                var sprite = new THREE.Sprite(material);
                sprite.position.set(j * Canvas.step, 0, i * Canvas.step * -1);
                sprite.scale.set(50, 50, 1);
                Canvas.scene.add(sprite);
            }
        }
    }
}
