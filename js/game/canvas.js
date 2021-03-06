var Canvas = {};

// Constants & elements
Canvas.WIDTH = 768;
Canvas.HEIGHT = 600;
Canvas.VIEW_ANGLE = 35;
Canvas.ASPECT = Canvas.WIDTH / Canvas.HEIGHT;
Canvas.NEAR = 0.1;
Canvas.FAR = 20000;
Canvas.step = 50;
Canvas.objWidth = 400;

Canvas.walls = [];
Canvas.floors = [];
Canvas.ceilings = [];
Canvas.objects = [];
Canvas.monsters = [];
Canvas.mustRender = false;

Canvas.time = 0;

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

    // Light
    var light = new THREE.PointLight(0xFFFFFF, 3, 200);
    scene.add(light);

    // Sky
    var sky = new THREE.Mesh(
        new THREE.SphereGeometry(10000, 60, 40),
        new THREE.MeshBasicMaterial({
            map: THREE.ImageUtils.loadTexture('img/cei/day.jpg'),
            side: THREE.DoubleSide
        })
    );

    scene.add(sky);

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

    var time = new Date().getTime();

    if (time > Canvas.time + 500) {
        Canvas.time = time;

        // Elements update
        Canvas.update();
        Canvas.mustRender = true;
    }

    // Render scene
    if (Canvas.mustRender) {
        Canvas.updateCamera();
        Canvas.render();
        Canvas.mustRender = false;
    }
}

Canvas.updateCamera = function() {
    /* Camera rotation */
    Canvas.camera.rotation.y = -Game.player.direction * (Math.PI / 2);

    /* Camera position => Player */
    Canvas.camera.position.x = Game.player.x * Canvas.step;
    Canvas.camera.position.z = -Game.player.y * Canvas.step;
    Canvas.light.position = Canvas.camera.position;

    /* Translation for vision */
    Canvas.camera.translateZ(Canvas.step);
}

Canvas.update = function() {
    /* Animated textures & monsters */
    for (i in Canvas.objects) {
        if (Canvas.objects[i].image.width > Canvas.objWidth) {
            var offset = Canvas.objects[i].offset.x + Canvas.objWidth / Canvas.objects[i].image.width;

            if (offset >= 1) {
                Canvas.objects[i].offset.x = 0;
            } else {
                Canvas.objects[i].offset.x = offset;
            }
        }
    }

    for (i in Canvas.monsters) {
        if (Canvas.monsters[i].image.width > Canvas.objWidth) {
            var offset = Canvas.monsters[i].offset.x + Canvas.objWidth / Canvas.monsters[i].image.width;

            if (offset >= 1) {
                Canvas.monsters[i].offset.x = 0;
            } else {
                Canvas.monsters[i].offset.x = offset;
            }
        }
    }
}

Canvas.render = function() {
    Canvas.renderer.render(Canvas.scene, Canvas.camera);
}

Canvas.loadMap = function(map) {
    /* Load a 3D map and make the meshes & sprites */ 
    for (i = 0; i < map.tiles.length; ++i) {
        for (j = 0; j < map.tiles[i].length; ++j) {

            /* Walls */
            if (map.tiles[i][j] != 0) {
                // Load on demand 
                if (typeof Canvas.walls[map.tiles[i][j] - 1] == 'undefined') {
                    Canvas.walls[map.tiles[i][j] - 1] = new THREE.ImageUtils.loadTexture('img/wal/' + map.tiles[i][j] + '.jpg');
                }

                var material = new THREE.MeshLambertMaterial({
                    map: Canvas.walls[map.tiles[i][j] - 1]
                });
                var geo = new THREE.CubeGeometry(Canvas.step, Canvas.step * 0.6, Canvas.step);
                var mesh = new THREE.Mesh(geo, material);

                mesh.position.x = j * Canvas.step;
                mesh.position.z = i * Canvas.step * -1;
                mesh.position.y = 0;

                // Add the meshes to the scene
                Canvas.scene.add(mesh);
            }

            if (map.floors[i][j] != 0) {
                if (typeof Canvas.floors[map.floors[i][j] - 1] == 'undefined') {
                    Canvas.floors[map.floors[i][j] - 1] = new THREE.ImageUtils.loadTexture('img/flr/' + map.floors[i][j] + '.jpg');
                }

                var material = new THREE.MeshLambertMaterial({
                    map: Canvas.floors[map.floors[i][j] - 1]
                });
                var geo = new THREE.CubeGeometry(Canvas.step, Canvas.step / 10, Canvas.step);
                var mesh = new THREE.Mesh(geo, material);

                mesh.position.x = j * Canvas.step;
                mesh.position.z = i * Canvas.step * -1;
                mesh.position.y = -Canvas.step * 0.3 - Canvas.step / 20;

                if ((i + j) % 2 == 0) {
                    mesh.rotation.y = Math.PI;
                }

                // Add the meshes to the scene
                Canvas.scene.add(mesh);
            }
            
            if (map.ceilings[i][j] != 0) { 
                if (typeof Canvas.ceilings[map.ceilings[i][j] - 1] == 'undefined') {
                    Canvas.ceilings[map.ceilings[i][j] - 1] = new THREE.ImageUtils.loadTexture('img/cei/' + map.ceilings[i][j] + '.jpg');
                }

                var material = new THREE.MeshLambertMaterial({
                    map: Canvas.ceilings[map.ceilings[i][j] - 1]
                });
                var geo = new THREE.CubeGeometry(Canvas.step, Canvas.step / 10, Canvas.step);
                var mesh = new THREE.Mesh(geo, material);

                mesh.position.x = j * Canvas.step;
                mesh.position.z = i * Canvas.step * -1;
                mesh.position.y = Canvas.step * 0.3 + Canvas.step / 20;

                if ((i + j) % 2 == 0) {
                    mesh.rotation.y = Math.PI;
                }

                // Add the meshes to the scene
                Canvas.scene.add(mesh);
            }

            /* Objects */
            if (map.objects[i][j] != 0) {
                if (typeof Canvas.objects[map.objects[i][j] - 1] == 'undefined') {
                    var texture = new THREE.ImageUtils.loadTexture('img/obj/' + map.objects[i][j] + '.png', null, function(txt) {
                        if (txt.image.width > Canvas.objWidth) {
                            txt.repeat.x = Canvas.objWidth / txt.image.width;
                        }
                    });

                    Canvas.objects[map.objects[i][j] - 1] = texture;
                }

                var material = new THREE.MeshLambertMaterial({
                    map: Canvas.objects[map.objects[i][j] - 1],
                    transparent: true,
                    color: new THREE.Color(0x666666)
                });
                var geo = new THREE.PlaneGeometry(Canvas.step * 0.5, Canvas.step * 0.5);
                var sprite = new THREE.Mesh(geo, material);

                sprite.position.set(j * Canvas.step, -Canvas.step / 20, i * Canvas.step * -1);
                sprite.quaternion = Canvas.camera.quaternion;
                Canvas.scene.add(sprite);
S = sprite;
            }

            /* Monsters */
            if (map.monsters[i][j] != 0) {
                if (typeof Canvas.monsters[map.monsters[i][j] - 1] == 'undefined') {
                    var texture = new THREE.ImageUtils.loadTexture('img/mon/' + map.monsters[i][j] + '.png', null, function(txt) {
                        if (txt.image.width > Canvas.objWidth) {
                            txt.repeat.x = Canvas.objWidth / txt.image.width;
                        }
                    });

                    Canvas.monsters[map.monsters[i][j] - 1] = texture;
                }

                var material = new THREE.MeshLambertMaterial({
                    map: Canvas.monsters[map.monsters[i][j] - 1],
                    transparent: true,
                    color: new THREE.Color(0x666666)
                });
                var geo = new THREE.PlaneGeometry(Canvas.step * 0.5, Canvas.step * 0.5);
                var sprite = new THREE.Mesh(geo, material);

                sprite.position.set(j * Canvas.step, -Canvas.step / 20, i * Canvas.step * -1);
                sprite.quaternion = Canvas.camera.quaternion;
                Canvas.scene.add(sprite);
            }
        }
    }
}
