import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class World {
    Car car;
    Map map;
    Sling sling;
    //ArrayList<Pin> pins;
    boolean turning=false;

    public World( )  throws IOException {
       //   pins= new ArrayList<Pin>()   ;
       //int x=500;
       //int y=500;
       //for (int i = 0; i < 10; i++) {
       //    pins.add(new Pin(x,y,12));
       //    x+=500;
       //    y-=500;
       //}
       map= new Map();
       car= new Car(map);
       sling= new Sling(map);

    }

    void draw(Graphics g,int windowWidth, int windowHeight){
        Graphics2D g2 = (Graphics2D) g;
        if (car.youWin()==false) {
            double dxTranslate = windowWidth / 2 - car.x - car.skin.getWidth() / 2;
            double dyTranslate = windowHeight / 2 - car.y - car.skin.getHeight() / 2;
            car.draw(g2, dxTranslate, dyTranslate);
            map.draw(g2, dxTranslate, dyTranslate);
            if (turning == true) {
                sling.draw(g2, car, dxTranslate, dyTranslate);
            } else {

            }
        } else {
            g2.drawString("Y O U  W I N ! ! !",350,400);
        }
       //for (int i = 0; i < pins.size() ; i++) {
       //     pins.get(i).draw(g2,dxTranslate, dyTranslate) ;
       //}
    }


    void update(double dt) {


        car.isCollided();
        car.youWin();
        if(turning ==true) {
            car.turning(sling);
            //car.getSpeedDirection();
        } else{
            car.driveForward(dt);
        }
    }
}
