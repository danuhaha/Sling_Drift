import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class SkinPanel extends JPanel {
    BufferedImage skin1 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Blue.PNG"));
    BufferedImage skin2 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/LightBlue.PNG"));
    BufferedImage skin3 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Red.png"));
    BufferedImage skin4 = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Green.PNG"));
    ImageIcon skin1Image = new ImageIcon(skin1);
    ImageIcon skin2Image = new ImageIcon(skin2);
    ImageIcon skin3Image = new ImageIcon(skin3);
    ImageIcon skin4Image = new ImageIcon(skin4);
    boolean chosen = false;

    SkinPanel(GamePanel gamePanel) throws IOException {
        setLayout(null);
        JLabel label = new JLabel("Choose your car");
        label.setBounds(280, 55, 400, 35);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30));
        resize();
        JButton skin1Button = new JButton(skin1Image);
        JButton skin2Button = new JButton(skin2Image);
        JButton skin3Button = new JButton(skin3Image);
        JButton skin4Button = new JButton(skin4Image);
        skin1Button.setBounds(150, 150, 200, 200);
        skin2Button.setBounds(450, 150, 200, 200);
        skin3Button.setBounds(150, 450, 200, 200);
        skin4Button.setBounds(450, 450, 200, 200);
        skin1Button.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skin2Button.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skin3Button.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skin4Button.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        skin1Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin1;
            chosen = true;
        });
        skin2Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin2;
            chosen = true;
        });
        skin3Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin3;
            chosen = true;
        });
        skin4Button.addActionListener(e -> {
            gamePanel.world.car.skin = skin4;
            chosen = true;
        });
        add(skin1Button);
        add(skin2Button);
        add(skin3Button);
        add(skin4Button);
        add(label);
    }

    void resize() {
        Image sk1 = skin1Image.getImage();
        Image sk2 = skin2Image.getImage();
        Image sk3 = skin3Image.getImage();
        Image sk4 = skin4Image.getImage();
        Image sk1Res = sk1.getScaledInstance(180, 200, Image.SCALE_REPLICATE);
        Image sk2Res = sk2.getScaledInstance(200, 200, Image.SCALE_REPLICATE);
        Image sk3Res = sk3.getScaledInstance(200, 200, Image.SCALE_REPLICATE);
        Image sk4Res = sk4.getScaledInstance(180, 200, Image.SCALE_REPLICATE);
        skin1Image = new ImageIcon(sk1Res);
        skin2Image = new ImageIcon(sk2Res);
        skin3Image = new ImageIcon(sk3Res);
        skin4Image = new ImageIcon(sk4Res);
    }


}
