import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Base64;

public class Sling {
    double xCar;
    double yCar;
    ArrayList<Integer> xCorners= new ArrayList<Integer>();
    ArrayList<Integer> yCorners= new ArrayList<Integer>();
    ArrayList<Double> radiuses = new ArrayList<Double>();



    public Sling(Map map){
        for (int i = 0; i <map.cornersX.size() ; i++) {
              xCorners.add(map.cornersX.get(i));
              yCorners.add(map.cornersY.get(i));
        }


    }
    void draw(Graphics g,Car car, double dxTranslate, double dyTranslate){
        xCar=car.x+ car.skin.getWidth()/2;
        yCar=car.y+car.skin.getHeight()/2 ;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g2.setColor(Color.darkGray);
        for (int i = 0; i <xCorners.size() ; i++) {
              radiuses.add(Math.sqrt((car.x - xCorners.get(i)) * (car.x - xCorners.get(i)) + (car.y - yCorners.get(i)) * (car.y- yCorners.get(i))));
        }
        double r=radiuses.get(0);
        for (int i = 0; i <radiuses.size(); i++) {
              if(radiuses.get(i)<r){
                  r=radiuses.get(i);

              }
        }

        g2.drawLine((int)(dxTranslate+xCar),(int)(dyTranslate+yCar),(int)(dxTranslate+xCorners.get(car.closest)),(int)(dyTranslate+yCorners.get(car.closest)));
        //g2.setColor(Color.black);
        //g2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
        //g2.drawLine((int)(dxTranslate+car.x),(int)(dyTranslate+car.y),(int)(dxTranslate+xCorners[car.closest]),(int)(dyTranslate+yCorners[car.closest]));
    }
}
