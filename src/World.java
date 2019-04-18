import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class World {
    Car car;
    Map map;
    Sling sling;
    boolean turning = false;
    BufferedImage youWin=ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Youwin.png"));


    World() throws IOException {
        map = new Map();
        car = new Car(map);
        sling = new Sling(map);
    }

    void draw(Graphics g, int windowWidth, int windowHeight)  {
        Graphics2D g2 = (Graphics2D) g;
        double dxTranslate = windowWidth / 2 - car.x - car.skin.getWidth() / 2;
        double dyTranslate = windowHeight / 2 - car.y - car.skin.getHeight() / 2;
        if (!car.youWin()) {
            car.draw(g2, dxTranslate, dyTranslate);
            map.draw(g2, dxTranslate, dyTranslate);
            if (turning) {
                sling.draw(g2, car, dxTranslate, dyTranslate);
            }
        }
        if (car.youWin()) {
            Font font = g2.getFont();
            g2.setFont(font.deriveFont(Font.PLAIN, 40));
            g2.drawString("Y O U  W I N ! ! !", (int) (dxTranslate + car.x - 100), (int) (dyTranslate + car.y - 100));
            //g2.drawImage(youWin, (int)(dxTranslate+car.x), (int)(dyTranslate+car.y), null);
        }
        if (car.isCollided()) {
            Font font = g2.getFont();
            g2.setFont(font.deriveFont(Font.PLAIN, 40));
            g2.drawString("G A M E  O V E R ", (int) (dxTranslate + car.x - 100), (int) (dyTranslate + car.y - 100));
        }
    }


    void update(double dt) {
        if (!car.isCollided()) {
            if (!car.youWin()) {
                car.isCollided();
                car.youWin();
                if (turning) {
                    car.turning();
                    car.getSpeedDirection();
                } else {
                    car.driveForward();
                }
            }
        }
    }
}
