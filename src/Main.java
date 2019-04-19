import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        JFrame frame = new JFrame();
        GamePanel panel = new GamePanel();
        SkinPanel skinChooser = new SkinPanel(panel);
        MenuPanel menu= new MenuPanel();
        LevelPanel levels = new LevelPanel(panel);
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(menu);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(e -> {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    panel.world.turning = true;
                }
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    frame.remove(panel);
                    menu.skinPanelChosen = false;
                    menu.gamePanelChosen = false;
                    skinChooser.chosen=false;
                    frame.add(menu);
                    panel.world.car.x=340;
                    panel.world.car.y=750;
                    panel.world.car.vel= new Vector2(0, -4);
                    panel.world.car.angleCar = 0;
                }
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    panel.world.turning = false;

                }
            }
            return false;
        });


        while (true) {
            Thread.sleep(10);
            if(menu.skinPanelChosen){
                frame.remove(menu);
                frame.add(skinChooser);
                frame.setVisible(true);
            }
            if(menu.levelPanelChosen){
                frame.remove(menu);
                frame.add(levels);
                frame.setVisible(true);
            }
            if(levels.levelChosen){
                frame.remove(levels);
                frame.add(menu);
            }
            if(skinChooser.chosen){
                frame.remove(skinChooser);
                frame.add(menu);
            }
            if (menu.gamePanelChosen) {
                frame.remove(menu);
                frame.add(panel);
                frame.setVisible(true);
                panel.world.update(10);
                if (panel.world.turning) {
                    if (panel.world.car.angle2 > panel.world.car.angle1) {
                        panel.world.car.angleA += 0.02;
                    } else {
                        panel.world.car.angleA -= 0.02;
                    }
                }
            }
            frame.repaint();
        }
    }
}
