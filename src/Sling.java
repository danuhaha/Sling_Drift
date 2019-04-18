import java.awt.*;
import java.util.ArrayList;

public class Sling {
    double xCar;
    double yCar;
    ArrayList<Integer> xCorners = new ArrayList<Integer>();
    ArrayList<Integer> yCorners = new ArrayList<Integer>();

    public Sling(Map map) {
        for (int i = 0; i < map.cornersX.size(); i++) {
            xCorners.add(map.cornersX.get(i));
            yCorners.add(map.cornersY.get(i));
        }
    }

    void draw(Graphics g, Car car, double dxTranslate, double dyTranslate) {
        xCar = car.x + car.skin.getWidth() / 2;
        yCar = car.y + car.skin.getHeight() / 2;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g2.setColor(Color.darkGray);
        g2.drawLine((int) (dxTranslate + xCar), (int) (dyTranslate + yCar), (int) (dxTranslate + xCorners.get(car.closest)), (int) (dyTranslate + yCorners.get(car.closest)));
    }
}
