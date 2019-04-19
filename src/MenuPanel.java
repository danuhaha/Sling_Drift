import sun.misc.IOUtils;
import sun.swing.ImageIconUIResource;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MenuPanel extends JPanel  {
    boolean skinPanelChosen = false;
    boolean gamePanelChosen = false;
    boolean levelPanelChosen=false;
    BufferedImage levelImage;
    BufferedImage playImage;
    BufferedImage skinImage;




    MenuPanel() throws  IOException{
        levelImage= ImageIO.read(MenuPanel.class.getResourceAsStream("levels.png")) ;
        playImage= ImageIO.read(MenuPanel.class.getResourceAsStream("PlayButton.png"));
        skinImage= ImageIO.read(MenuPanel.class.getResourceAsStream("skin.png"));
         ImageIcon play = new ImageIcon(playImage);
         ImageIcon skin = new ImageIcon(skinImage);
        ImageIcon levels= new ImageIcon(levelImage);
        setLayout(null);
        JLabel playlabel = new JLabel("Play");
        JLabel skinLabel= new JLabel("Choose the skin");
        JLabel levelsLabel = new JLabel("Choose the level");
        playlabel.setFont(new Font(playlabel.getFont().getName(), Font.PLAIN, 20));
        levelsLabel.setFont(new Font(levelsLabel.getFont().getName(), Font.PLAIN, 20));
        skinLabel.setFont(new Font(skinLabel.getFont().getName(), Font.PLAIN, 20));
        skinLabel.setBounds(60,435,325,20);
        playlabel.setBounds(360,435,300,20);
        levelsLabel.setBounds(560,435,300,20);

        JButton levelSelector = new JButton(levels);
        JButton skinPanel = new JButton(skin);
        JButton gamePanel = new JButton(play);

        skinPanel.setBounds(30, 250, 200, 200);
        skinPanel.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        gamePanel.setBounds(280, 250, 200, 200);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        levelSelector.setBounds(530,250,220,200);
        levelSelector.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skinPanel.addActionListener(e -> {
            skinPanelChosen = true;
        });
        gamePanel.addActionListener(e -> {
            gamePanelChosen = true;
        });
        levelSelector.addActionListener(e -> {
            levelPanelChosen = true;
        });
        add(gamePanel);
        add(skinPanel);
        add(levelSelector);
        add(skinLabel);
        add(playlabel);
        add(levelsLabel);
    }


}
