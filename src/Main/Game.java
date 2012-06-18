/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author mrojas
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    public static RPG.Map map;
    public static RPG.Party party;
    public static short dx;
    public static short dy;
    public static byte status;
    
    public final static short T_SIZE = 20;

    public final static byte IS_GAME        = 1;
    public final static byte IS_SHOP        = 2;
    public final static byte IS_MAP         = 3;
    public final static byte IS_CUTSCENE    = 4;
    public final static byte IS_PARTYSTATUS = 5;
    public final static byte IS_QUESTS      = 6;
    
    public Game() {
        initComponents();

        /* Init */
        try {
            Game.map   = new RPG.Map("map1");
        } catch(Exception e) {
            this.ohNoCrash(new Exception("Map can't be loaded"));
        }

        Game.party  = new RPG.Party(Game.map.startX, Game.map.startY);
        Game.status = Game.IS_GAME;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Screen = new Mapview();
        buttonTurnLeft = new javax.swing.JButton();
        buttonUp = new javax.swing.JButton();
        buttonTurnRight = new javax.swing.JButton();
        buttonStrafeLeft = new javax.swing.JButton();
        buttonDown = new javax.swing.JButton();
        buttonStrafeRight = new javax.swing.JButton();
        buttonAction = new javax.swing.JButton();
        buttonQuests = new javax.swing.JButton();
        buttonParty = new javax.swing.JButton();
        gameButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fans Of Might & Magic");
        setResizable(false);

        Screen.setBackground(new java.awt.Color(1, 1, 1));

        javax.swing.GroupLayout ScreenLayout = new javax.swing.GroupLayout(Screen);
        Screen.setLayout(ScreenLayout);
        ScreenLayout.setHorizontalGroup(
            ScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        ScreenLayout.setVerticalGroup(
            ScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        buttonTurnLeft.setText("\\");
            buttonTurnLeft.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonTurnLeftActionPerformed(evt);
                }
            });

            buttonUp.setText("^");
            buttonUp.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonUpActionPerformed(evt);
                }
            });

            buttonTurnRight.setText("/");
            buttonTurnRight.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonTurnRightActionPerformed(evt);
                }
            });

            buttonStrafeLeft.setText("<");
            buttonStrafeLeft.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonStrafeLeftActionPerformed(evt);
                }
            });

            buttonDown.setText("V");
            buttonDown.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonDownActionPerformed(evt);
                }
            });

            buttonStrafeRight.setText(">");
            buttonStrafeRight.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonStrafeRightActionPerformed(evt);
                }
            });

            buttonAction.setText("Action");
            buttonAction.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonActionActionPerformed(evt);
                }
            });

            buttonQuests.setText("Quests");
            buttonQuests.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    buttonQuestsMouseClicked(evt);
                }
            });

            buttonParty.setText("Party");
            buttonParty.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    buttonPartyMouseClicked(evt);
                }
            });

            gameButton.setText("Back to Game");
            gameButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    gameButtonMouseClicked(evt);
                }
            });

            fileMenu.setMnemonic('f');
            fileMenu.setText("File");

            openMenuItem.setMnemonic('o');
            openMenuItem.setText("Open");
            fileMenu.add(openMenuItem);

            saveMenuItem.setMnemonic('s');
            saveMenuItem.setText("Save");
            fileMenu.add(saveMenuItem);

            saveAsMenuItem.setMnemonic('a');
            saveAsMenuItem.setText("Save As ...");
            saveAsMenuItem.setDisplayedMnemonicIndex(5);
            fileMenu.add(saveAsMenuItem);

            exitMenuItem.setMnemonic('x');
            exitMenuItem.setText("Exit");
            exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    exitMenuItemActionPerformed(evt);
                }
            });
            fileMenu.add(exitMenuItem);

            menuBar.add(fileMenu);

            helpMenu.setMnemonic('h');
            helpMenu.setText("Help");

            contentsMenuItem.setMnemonic('c');
            contentsMenuItem.setText("Contents");
            helpMenu.add(contentsMenuItem);

            aboutMenuItem.setMnemonic('a');
            aboutMenuItem.setText("About");
            aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    aboutMenuItemActionPerformed(evt);
                }
            });
            helpMenu.add(aboutMenuItem);

            menuBar.add(helpMenu);

            setJMenuBar(menuBar);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Screen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonStrafeLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonTurnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(buttonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buttonTurnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(buttonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buttonStrafeRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(9, 9, 9))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gameButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonQuests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonParty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(0, 0, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Screen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(buttonQuests)
                    .addGap(18, 18, 18)
                    .addComponent(buttonParty)
                    .addGap(18, 18, 18)
                    .addComponent(gameButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAction)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonTurnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonTurnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonStrafeLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonStrafeRight, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void buttonUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpActionPerformed
        Game.dy = -1;
        Game.dx = 0;
        this.update();
    }//GEN-LAST:event_buttonUpActionPerformed

    private void buttonDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDownActionPerformed
        Game.dy = 1;
        Game.dx = 0;
        this.update();
    }//GEN-LAST:event_buttonDownActionPerformed

    private void buttonStrafeLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStrafeLeftActionPerformed
        Game.dy = 0;
        Game.dx = -1;
        this.update();
    }//GEN-LAST:event_buttonStrafeLeftActionPerformed

    private void buttonStrafeRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStrafeRightActionPerformed
        Game.dy = 0;
        Game.dx = 1;
        this.update();
    }//GEN-LAST:event_buttonStrafeRightActionPerformed

    private void buttonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionActionPerformed
        //Code for "space bar"
    }//GEN-LAST:event_buttonActionActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(rootPane, "This is Fans of Might 6 Magic", "FOMM - About", JOptionPane.INFORMATION_MESSAGE, null);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void buttonTurnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTurnLeftActionPerformed
        Game.party.left();
        this.Screen.repaint();
        /** @todo: This action can't trigger monster/time update */
    }//GEN-LAST:event_buttonTurnLeftActionPerformed

    private void buttonTurnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTurnRightActionPerformed
        Game.party.right();
        this.Screen.repaint();
        /** @todo: Same deal with previous event */
    }//GEN-LAST:event_buttonTurnRightActionPerformed

    private void buttonPartyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPartyMouseClicked
        Game.status = Game.IS_PARTYSTATUS;
        this.Screen.repaint();
    }//GEN-LAST:event_buttonPartyMouseClicked

    private void buttonQuestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonQuestsMouseClicked
        Game.status = Game.IS_QUESTS;
        this.Screen.repaint();
    }//GEN-LAST:event_buttonQuestsMouseClicked

    private void gameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameButtonMouseClicked
        Game.status = Game.IS_GAME;
        this.Screen.repaint();
    }//GEN-LAST:event_gameButtonMouseClicked


    /**
     * Methods and implementations
     */
    public void update() {
        /* 
         * Colisions, impassables & another conditions of map tiles, in case you're moving 
         */
        if (Game.dx!=0 || Game.dy!=0) {
            RPG.Tile tmp = Game.map.tile(Game.party.X + Game.dx, Game.party.Y + Game.dy);

            if (tmp != null) {
                if (!tmp.flags[RPG.Tile.IMPASSABLE]) { // Tile is impassable
                    Game.party.X += Game.dx;
                    Game.party.Y += Game.dy;

                    Game.dx = 0;
                    Game.dy = 0;
                }
            }
        }

        /* 
         * Events triggers 
         */
        Object[] ev = Game.map.event(Game.party.X, Game.party.Y);

        if (ev != null) {
            this.triggerEvents(ev);
        }

        /*
         * Everything is set. Let's draw all again...
         */
        this.Screen.repaint();
    }

    public void triggerEvents(Object[] evs) {
        String data = "";
        
        for (int i = 0; i < evs.length; ++i) {

            RPG.Event ev = (RPG.Event)evs[i];
            String[] params;

            System.out.println("event : " + i);
            System.out.println("code  : " + ev.code);
            System.out.println("data  : " + data);
            System.out.println("param : " + ev.parameter + "\n");            

            switch(ev.code) {
                /* Kills an event */
                case RPG.Event.KILL_EVENT:
                    try {
                        Game.map.killEvent(Integer.parseInt(ev.parameter));
                    } catch(Exception e) {
                        this.ohNoCrash(e);
                    }

                    break;




                /* Shows a message everytime is triggered */
                case RPG.Event.MESSAGE:
                    JOptionPane.showMessageDialog(rootPane, ev.parameter);
                    break;

                /* Shows a message, but just one time */
                case RPG.Event.MESSAGE_ONETIME:
                    JOptionPane.showMessageDialog(rootPane, ev.parameter);
                    ev.alive = false;
                    break;

                /* Show a NPC talking */
                case RPG.Event.MESSAGE_NPC:
                    params = ev.parameter.split(";");

                    if (params.length != 2) {
                        this.ohNoCrash(new Exception("NPC_MESSAGE event trigger malformed parameter : " + ev.parameter));
                    }

                    JOptionPane.showMessageDialog(rootPane, params[1], params[0], JOptionPane.INFORMATION_MESSAGE);
                    break;


                /* Confirm */
                case RPG.Event.CONFIRM:
                    int j = JOptionPane.showConfirmDialog(rootPane, ev.parameter);

                    if (j == 0) {
                        data = "ok";
                    } else {
                        data = "no";
                    }

                    break;

                /* Input */
                case RPG.Event.INPUT:
                    data = JOptionPane.showInputDialog(rootPane, ev.parameter);

                    if (data==null) {
                        data = "";
                    }

                    break;

                /* IF */
                case RPG.Event.IF:
                    params = ev.parameter.split(";");

                    if (params.length != 3) {
                        this.ohNoCrash(new Exception("IF event trigger malformed parameter : " + ev.parameter));
                    }

                    if (data.equals(params[0])) {
                        i = Integer.parseInt(params[1]) - 1;
                    } else {
                        i = Integer.parseInt(params[2]) - 1;
                    }

                    break;




                /* Give some treasure (gold;gems;food) */
                case RPG.Event.TREASURE:
                    params = ev.parameter.split(";");

                    if (params.length != 3) {
                        this.ohNoCrash(new Exception("TREASURE event trigger malformed parameter : " + ev.parameter));
                    }

                    Game.party.gold += Integer.parseInt(params[0]);
                    Game.party.gems += Integer.parseInt(params[1]);
                    Game.party.food += Integer.parseInt(params[2]);

                    JOptionPane.showMessageDialog(rootPane, "Party found:\n" + 
                            params[0] + " gold\n" +
                            params[1] + " gems\n" +
                            "\n");

                    break;

                /* Give some experience to the whole party */
                case RPG.Event.EXPERIENCE_PARTY:
                    JOptionPane.showMessageDialog(rootPane, ev.parameter + " experience(each)");
                    break;

                /* Give some experience to one party member */
                case RPG.Event.EXPERIENCE_ONE:
                    JOptionPane.showMessageDialog(rootPane, ev.parameter + " experience(each)");
                    break;




                /* Gives a quest */
                case RPG.Event.GIVE_QUEST:
                    params = ev.parameter.split(";");
                    
                    if (params.length != 2) {
                        this.ohNoCrash(new Exception("GIVE_QUEST event trigger malformed parameter : " + ev.parameter));
                    }

                    Game.party.addQuest(Integer.parseInt(params[0]), params[1]);
                    break;

                /* Complete a quest */
                case RPG.Event.END_QUEST:
                    Game.party.removeQuest(Integer.parseInt(ev.parameter));
                    break;

                /* IF quest exists */
                case RPG.Event.IF_QUEST:
                    params = ev.parameter.split(";");

                    if (params.length != 3) {
                        this.ohNoCrash(new Exception("IF_QUEST event trigger malformed parameter : " + ev.parameter));
                    }

                    if (Game.party.hasQuest(Integer.parseInt(params[0]))) {
                        i = Integer.parseInt(params[1]) - 1;
                    } else {
                        i = Integer.parseInt(params[2]) - 1;
                    }

                    break;




                /* Gives a quest */
                case RPG.Event.GIVE_QUESTITEM:
                    params = ev.parameter.split(";");
                    
                    if (params.length != 3) {
                        this.ohNoCrash(new Exception("GIVE_QUESTITEM event trigger malformed parameter : " + ev.parameter));
                    }

                    Game.party.addQuestItem(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]));
                    JOptionPane.showMessageDialog(rootPane, "Party found: \n\n" + params[2] + " " + params[1]);
                    
                    break;

                /* Complete a quest */
                case RPG.Event.TAKE_QUESTITEM:
                    params = ev.parameter.split(";");
                    
                    if (params.length != 2) {
                        this.ohNoCrash(new Exception("TAKE_QUESTITEM event trigger malformed parameter : " + ev.parameter));
                    }

                    Game.party.removeQuestItem(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
                    break;

                /* IF quest exists */
                case RPG.Event.IF_QUESTITEM:
                    params = ev.parameter.split(";");

                    if (params.length != 4) {
                        this.ohNoCrash(new Exception("IF_QUESTITEM event trigger malformed parameter : " + ev.parameter));
                    }

                    if (Game.party.hasQuestItem(Integer.parseInt(params[0]), Integer.parseInt(params[1]))) {
                        i = Integer.parseInt(params[2]) - 1;
                    } else {
                        i = Integer.parseInt(params[3]) - 1;
                    }

                    break;





                /* Change map */
                case RPG.Event.CHANGE_MAP:
                    try {
                        Game.map = new RPG.Map("map" + Integer.parseInt(ev.parameter));
                    } catch (Exception e) {
                        this.ohNoCrash(new Exception("Map can't be loaded"));
                    }
                    break;

                /* Exit script */
                case RPG.Event.EXIT:
                    data = "exit";
                    break;

                default:
                    break;
            }

            /* Exit script? */
            if (data.equals("exit")) {
                break;
            }
        }
        
    }

    public void ohNoCrash(Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Fatal error : " + e.toString(), "FOMM - Dialog", JOptionPane.ERROR_MESSAGE, null);
        System.exit(1);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Game().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Screen;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton buttonAction;
    private javax.swing.JButton buttonDown;
    private javax.swing.JButton buttonParty;
    private javax.swing.JButton buttonQuests;
    private javax.swing.JButton buttonStrafeLeft;
    private javax.swing.JButton buttonStrafeRight;
    private javax.swing.JButton buttonTurnLeft;
    private javax.swing.JButton buttonTurnRight;
    private javax.swing.JButton buttonUp;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton gameButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}


/* Class for graphics */
class Mapview extends javax.swing.JPanel {
    private BufferedImage base;
    private BufferedImage wall;
    private BufferedImage thing;

    public Mapview() {
        try {
            /* Load tiles */
            this.base = ImageIO.read(getClass().getResource("/Assets/images/base.png"));
            this.wall = ImageIO.read(getClass().getResource("/Assets/images/wall.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        /* Wich is gonna be rendered */
        switch (Game.status) {
            case Game.IS_GAME:
                this.renderMap(Game.map, g);
                this.renderParty(Game.party, g);
                break;
            case Game.IS_PARTYSTATUS:
                this.renderPartyStatus(Game.party, g);
                break;
            case Game.IS_QUESTS:
                renderPartyQuests(Game.party, g);
                break;
            default:
                break;
        }
    }
    
    public void renderMap(RPG.Map M, java.awt.Graphics g) {
        /* Render map */
        int w = Game.map.width;
        int h = Game.map.height;
       
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {                
                RPG.Tile t = Game.map.tile(i, j);

                g.drawImage(this.base, 
                        i * Game.T_SIZE, j * Game.T_SIZE, (i+1) * Game.T_SIZE, (j+1) * Game.T_SIZE, 
                        (t.base%5) * Game.T_SIZE, (int)(t.base/5) * Game.T_SIZE, (t.base%5 + 1) * Game.T_SIZE, ((int)(t.base/5) + 1) * Game.T_SIZE, 
                        this);
                g.drawImage(this.wall, 
                        i * Game.T_SIZE, j * Game.T_SIZE, (i+1) * Game.T_SIZE, (j+1) * Game.T_SIZE, 
                        (t.wall%5) * Game.T_SIZE, (int)(t.wall/5) * Game.T_SIZE, (t.wall%5 + 1) * Game.T_SIZE, ((int)(t.wall/5) + 1) * Game.T_SIZE, 
                        this);
            }
        }
    }

    public void renderPartyStatus(RPG.Party P, java.awt.Graphics g) {
        
        /* Gold, food and all other stuff */
        g.setColor(Color.ORANGE);
        
        g.drawString("Quick Reference Chart", 10, 10);
        
        g.drawString("name # class level hp sp", 10, 40);

        for (int i = 0; i < P.chars.length; ++i) {
            g.drawString(P.chars[i].name + " " + i + " " +
                    " " + P.chars[i].clss +
                    " " + P.chars[i].level +
                    " " + P.chars[i].hp +
                    " " + P.chars[i].sp, 10, 20 + 20 * (i + 2));
        }
        
        g.drawString("Gold : " + Game.party.gold, 10, 120);
        g.drawString("Gems : " + Game.party.gems, 10, 130);
        g.drawString("Food : " + Game.party.food, 10, 140);        
    }
    
    public void renderPartyQuests(RPG.Party P, java.awt.Graphics g) {
        /* Gold, food and all other stuff */
        g.setColor(Color.ORANGE);
        
        g.drawString("Current Quests", 10, 10);
        
        if (P.quests.size() > 0) {
            for (int i = 0; i < P.quests.size(); ++i) {
                RPG.Quest tmp = (RPG.Quest)P.quests.get(i);
                g.drawString("x " + tmp.name, 10, 20 + 20 * (i + 1));
            }
        } else {
            g.drawString("You don't have any quests...", 10, 40);
        }
        
        if (P.quest_items.size() > 0) {
            for (int i = 0; i < P.quest_items.size(); ++i) {
                RPG.QuestItem tmp = (RPG.QuestItem)P.quest_items.get(i);
                g.drawString("- " + tmp.total + " " + tmp.name, 10, 200 + 20 * (i + 1));
            }
        } else {
            g.drawString("You don't have any quests items...", 10, 200);
        }
    }

    public void renderParty(RPG.Party P, java.awt.Graphics g) {
        g.setColor(Color.YELLOW);

        String pt = "";

        switch(P.facing) {
            case 0:
                pt = "^";
                break;
            case 1:
                pt = ">";
                break;
            case 2:
                pt = "v";
                break;
            case 3:
                pt = "<";
                break;
            default:
                pt = "?";
                break;
        }

        g.drawString(pt, (Game.T_SIZE * P.X + 8), (Game.T_SIZE * P.Y + 15));
    }
}
