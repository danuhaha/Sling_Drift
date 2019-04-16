import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException,InterruptedException {

        JFrame frame = new JFrame();
        GamePanel panel= new GamePanel();
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        KeyboardFocusManager manager= KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED){
                    if ( e.getKeyCode() == KeyEvent.VK_SPACE) {
                        panel.world.turning=true;


                    }
                } else if (e.getID() == KeyEvent.KEY_RELEASED){
                    if ( e.getKeyCode() == KeyEvent.VK_SPACE) {
                        panel.world.turning=false;

                    }
                }
                return false;
            }
        });

        while(true){
            Thread.sleep(10);
            if(panel.world.car.isCollided()==false) {
                panel.world.update(10);
                if (panel.world.turning == true) {
                    if (panel.world.car.angle2>panel.world.car.angle1) {
                        panel.world.car.angleA += 0.01;
                    }  else {
                         panel.world.car.angleA -= 0.01; 
                    }
                }
           }else{
           
           }
            frame.repaint();

        }
    }
}
