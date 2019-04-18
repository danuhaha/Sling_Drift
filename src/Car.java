import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Car {
    double x;
    double y;
    double angle2;
    double angle1;
    double angleA;
    double angleCar;
    double prevX;
    double prevY;
    Vector2 vel;
    BufferedImage skin = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Red.png"));
    Rectangle rect;
    int[] xCorners = new int[12];
    int[] yCorners = new int[12];
    double[] radiuses = new double[12];
    int closest = 0;
    Map map;

    public Car(Map map) throws IOException {
        x = 340;
        y = 750;
        angleA = 0;
        vel = new Vector2(0, -4);
        for (int i = 0; i < map.cornersX.size(); i++) {
            xCorners[i] = map.cornersX.get(i);
            yCorners[i] = map.cornersY.get(i);
        }
        this.map = map;
    }

    void draw(Graphics g, double dxTranslate, double dyTranslate) {
        Graphics2D g2 = (Graphics2D) g;
        double locationX = skin.getWidth() / 2;
        double locationY = skin.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(angleCar, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2.drawImage(op.filter(skin, null), (int) (dxTranslate + x), (int) (dyTranslate + y), null);
    }

    public boolean isCollided() {
        boolean b = false;
        for (int i = 0; i < map.leftSideLines.size(); i++)
            if (map.leftSideLines.get(i).intersects(this.getRectangle()) || map.rightSideLines.get(i).intersects(this.getRectangle())) {
                b = true;
                break;
            } else {
                b = false;
            }
        return b;
    }

    public boolean youWin() {
        return (x > 2200 && x < 2600) && y == -3890;
    }

    public Rectangle getRectangle() {
        rect = new Rectangle((int) (x), (int) y, skin.getWidth(), skin.getHeight());
        return rect;
    }

    void driveForward() {
        y += vel.y;
        x += vel.x;
    }

    void turning() {
        for (int i = 0; i < xCorners.length; i++) {
            radiuses[i] = Math.sqrt((x - xCorners[i]) * (x - xCorners[i]) + (y - yCorners[i]) * (y - yCorners[i]));
        }
        double r = radiuses[0];
        for (int i = 0; i < radiuses.length; i++) {
            if (radiuses[i] < r) {
                r = radiuses[i];
                closest = i;
            }
        }

        prevX = x;
        prevY = y;

        angleA = Math.atan2(y - yCorners[closest], x - xCorners[closest]);
        angle1 = Math.atan2(y - yCorners[closest], x - xCorners[closest]);
        angle2 = Math.atan2(y + vel.y - yCorners[closest], x + vel.x - xCorners[closest]);
        if (angle1 >= -Math.PI && angle1 <= 0) {
            if (angle2 > angle1 && angle2 < angle1 + Math.PI) {
                x = xCorners[closest] + r * Math.cos(angleA + 0.02);
                y = yCorners[closest] + r * Math.sin(angleA + 0.02);
                angleCar = Math.toRadians(270 - (360 - Math.toDegrees(angleA)) - 90);
            } else if (angle2 > angle1 && angle2 > angle1 + Math.PI) {
                x = xCorners[closest] + r * Math.cos(angleA - 0.02);
                y = yCorners[closest] + r * Math.sin(angleA - 0.02);
                angleCar = Math.toRadians(90 + (90 - (180 - Math.toDegrees(angleA))));
            } else if (angle2 < angle1 && angle2 > angle1 - Math.PI) {
                x = xCorners[closest] + r * Math.cos(angleA - 0.02);
                y = yCorners[closest] + r * Math.sin(angleA - 0.02);
                angleCar = Math.toRadians(90 + (90 - (180 - Math.toDegrees(angleA))));
            }
        } else if (angle1 <= Math.PI && angle1 > 0) {
            if ((angle2 > angle1 && angle2 < Math.PI) || (angle2 < angle1 - Math.PI)) {
                x = xCorners[closest] + r * Math.cos(angleA + 0.02);
                y = yCorners[closest] + r * Math.sin(angleA + 0.02);
                angleCar = Math.toRadians(270 - (360 - Math.toDegrees(angleA)) - 90);
            } else if ((angle2 < angle1 && angle2 > angle1 - Math.PI)) {
                x = xCorners[closest] + r * Math.cos(angleA - 0.02);
                y = yCorners[closest] + r * Math.sin(angleA - 0.02);
                angleCar = Math.toRadians(90 + (90 - (180 - Math.toDegrees(angleA))));
            }
        }
    }

    void getSpeedDirection() {
        vel.x = x - prevX;
        vel.y = y - prevY;
    }

}
