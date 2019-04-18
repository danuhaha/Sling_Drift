import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    ArrayList<Integer> leftSidePointsX = new ArrayList<Integer>();
    ArrayList<Integer> leftSidePointsY = new ArrayList<Integer>();
    ArrayList<Line2D> leftSideLines = new ArrayList<Line2D>();
    ArrayList<Integer> rightSidePointsX = new ArrayList<Integer>();
    ArrayList<Integer> rightSidePointsY = new ArrayList<Integer>();
    ArrayList<Line2D> rightSideLines = new ArrayList<Line2D>();
    ArrayList<Integer> cornersX = new ArrayList<Integer>();
    ArrayList<Integer> cornersY = new ArrayList<Integer>();
    File leftSide = new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/LeftBorder1.txt");
    File rightSide = new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/RightBorder1.txt");
    File corners = new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Corners1.txt");
    BufferedImage pin = ImageIO.read(new File("/Users/danuhaha/IdeaProjects/Sling_Drift/Resources/Pin.PNG"));

    public Map() throws IOException {
        Scanner scanner1 = new Scanner(leftSide);
        Scanner scanner2 = new Scanner(rightSide);
        Scanner scanner3 = new Scanner(corners);

        while (scanner1.hasNextInt()) {
            int x = scanner1.nextInt();
            int y = scanner1.nextInt();
            leftSidePointsX.add(x);
            leftSidePointsY.add(y);

        }


        while (scanner2.hasNextInt()) {
            int x = scanner2.nextInt();
            int y = scanner2.nextInt();
            rightSidePointsX.add(x);
            rightSidePointsY.add(y);

        }


        while (scanner3.hasNextInt()) {
            int x = scanner3.nextInt();
            int y = scanner3.nextInt();
            cornersX.add(x);
            cornersY.add(y);

        }


        for (int j = 0; j < leftSidePointsX.size() - 1; j++) {
            leftSideLines.add(new Line2D.Float((leftSidePointsX.get(j)), (leftSidePointsY.get(j)), (leftSidePointsX.get(j + 1)), (int) (leftSidePointsY.get(j + 1))));
        }
        for (int j = 0; j < rightSidePointsX.size() - 1; j++) {
            rightSideLines.add(new Line2D.Float((rightSidePointsX.get(j)), (rightSidePointsY.get(j)), (rightSidePointsX.get(j + 1)), (rightSidePointsY.get(j + 1))));
        }


    }

    void draw(Graphics g, double dxTranslate, double dyTranslate) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6));
        g2.setColor(Color.green);
        for (int i = 0; i < leftSidePointsX.size() - 1; i++) {
            g2.drawLine((int) (dxTranslate + leftSidePointsX.get(i)), (int) (dyTranslate + leftSidePointsY.get(i)), (int) (dxTranslate + leftSidePointsX.get(i + 1)), (int) (dyTranslate + leftSidePointsY.get(i + 1)));
        }
        for (int i = 0; i < rightSidePointsX.size() - 1; i++) {
            g2.drawLine((int) (dxTranslate + rightSidePointsX.get(i)), (int) (dyTranslate + rightSidePointsY.get(i)), (int) (dxTranslate + rightSidePointsX.get(i + 1)), (int) (dyTranslate + rightSidePointsY.get(i + 1)));
        }
        for (int i = 0; i < cornersX.size(); i++) {
            g2.drawImage(pin, (int) (dxTranslate + cornersX.get(i) - 33), (int) (dyTranslate + cornersY.get(i) - 33), null);
        }
        int x = 2200;
        int y = -4000;
        for (int i = 0; i < 60; i++) {
            g2.setColor(Color.black);
            g2.fillRect((int) (dxTranslate + x), (int) (dyTranslate + y), 10, 10);
            if (x <= 2570) {
                x += 20;
            } else {
                y += 10;
                if (y == -3990) {
                    x = 2210;
                } else if (y == -3980) {
                    x = 2200;
                }

            }

        }

    }
}