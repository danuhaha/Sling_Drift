import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    boolean skinPanelChosen = false;
    boolean gamePanelChosen = false;
    ImageIcon play = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/PlayButton.png");
    ImageIcon skin = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/skin.png");

    MenuPanel() {
        setLayout(null);
        JLabel playlabel = new JLabel("Play");
        JLabel choose= new JLabel("Choose the skin");
        playlabel.setFont(new Font(playlabel.getFont().getName(), Font.PLAIN, 20));
        choose.setFont(new Font(choose.getFont().getName(), Font.PLAIN, 20));
        JButton skinPanel = new JButton(skin);
        skinPanel.setBounds(80, 200, 325, 325);
        choose.setBounds(170,435,325,20);
        playlabel.setBounds(490,435,300,20);
        skinPanel.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        JButton gamePanel = new JButton(play);
        gamePanel.setBounds(350, 200, 325, 325);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skinPanel.addActionListener(e -> {
            skinPanelChosen = true;
        });
        gamePanel.addActionListener(e -> {
            gamePanelChosen = true;
        });
        add(gamePanel);
        add(skinPanel);
        add(choose);
        add(playlabel);
    }

}
