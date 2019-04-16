import java.awt.*;

public class Pin {
    int pinX;
    int pinY;
    int radius;

    public Pin(int x, int y, int r){
        pinX=x;
        pinY=y;
        radius=r;
    }
    void draw(Graphics g, double dxTranslate, double dyTranslate){
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.green);
        g3.drawOval((int)(dxTranslate+pinX),(int)(dyTranslate+pinY),radius,radius);
    }
}
