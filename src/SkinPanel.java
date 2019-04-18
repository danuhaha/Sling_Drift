import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class SkinPanel extends JPanel {
    private BufferedImage skin1;
    private BufferedImage skin2;
    private BufferedImage skin3;
    private BufferedImage skin4;
    ImageIcon skin1Image = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Blue.PNG");
    ImageIcon skin2Image = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/LightBlue.PNG");
    ImageIcon skin3Image = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Red.png");
    ImageIcon skin4Image = new ImageIcon("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Green.PNG");
    boolean chosen = false;

    SkinPanel(GamePanel gamePanel) throws IOException {
        setLayout(null);
        JButton skin1Button = new JButton(skin1Image);
        skin1Button.setBounds(50, 50, 325, 325);
        JButton skin2Button = new JButton(skin2Image);
        skin2Button.setBounds(425, 50,325, 325);
        JButton skin3Button = new JButton(skin3Image);
        skin3Button.setBounds(50, 425, 325, 325);
        JButton skin4Button = new JButton(skin4Image);
        skin4Button.setBounds(425, 425, 325, 325);
        skin1 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Blue.PNG"));
        skin1Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin1;
            chosen = true;
        });

        skin2 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/LightBlue.PNG"));
        skin2Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin2;
            chosen = true;
        });
        skin3 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Red.png"));
        skin3Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin3;
            chosen = true;
        });
        skin4 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Green.PNG"));
        skin4Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin4;
            chosen = true;
        });
        add(skin1Button);
        add(skin2Button);
        add(skin3Button);
        add(skin4Button);
    }


}
