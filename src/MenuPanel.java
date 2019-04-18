import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuPanel extends JPanel {
    boolean skinPanelChosen= false;
    boolean gamePanelChosen=false;
    ImageIcon play = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/PlayButton.png");
    ImageIcon skin= new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/skin.png");

    MenuPanel (){
        setLayout(null);
        JButton skinPanel= new JButton(skin);
        skinPanel.setBounds(80,200,325,325);
        skinPanel.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        JButton gamePanel= new JButton(play);
        gamePanel.setBounds(350,200,325,325);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skinPanel.addActionListener(e -> {
            skinPanelChosen = true;
        });
        gamePanel.addActionListener(e -> {
           gamePanelChosen = true;
        });
        add(gamePanel);
        add(skinPanel);
    }

}
