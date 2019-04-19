import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LevelPanel extends JPanel {
     BufferedImage level1Image;
     BufferedImage level2Image;
    boolean levelChosen=false;


    LevelPanel(GamePanel gamePanel) throws IOException {
        level1Image= ImageIO.read(MenuPanel.class.getResourceAsStream("level1.png")) ;
        level2Image= ImageIO.read(MenuPanel.class.getResourceAsStream("level2.png"));
        ImageIcon level1Icon = new ImageIcon(level1Image);
        ImageIcon level2Icon = new ImageIcon(level2Image);
        setLayout(null);
        JButton level1= new JButton(level1Icon);
        JButton level2= new JButton(level2Icon);
        level1.setBounds(150,300,200,200);
        level2.setBounds(450,300,200,200);
        level1.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        level2.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        level1.addActionListener(e -> {
            levelChosen = true;
        });
        level2.addActionListener(e -> {
           levelChosen = true;
        });
        add(level1);
        add(level2);
    }
}
