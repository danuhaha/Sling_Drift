import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {
    World world;

    public GamePanel() throws IOException {
        world= new World();
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        world.draw(g2, this.getWidth(), this.getHeight());
    }
}
