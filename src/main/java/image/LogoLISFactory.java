package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LogoLISFactory implements ImageFactory{

    /**
     * Initialise the coordinates and colors for each form. This method realise the logo LIS with rectangle form
     * @return
     */
    @Override
    public Image makeImage() {
        Color dark = Color.rgb(35,31,32);
        Color greenblue = Color.rgb(113,208,199);

        int[] xCoordinates = {60,  720, 660, 400, 0,   400, 660};
        int[] yCoordinates = {0,   60,  140, 0,   0,   140, 0};
        int[] widths =       {140, 140, 140, 60,  200, 60,  200};
        int[] heights =      {280, 80,  140, 80,  340, 200, 340};
        Color[] colors = {Color.WHITE, Color.WHITE, Color.WHITE, greenblue, dark, dark, dark};

        List<Shape> list = new ArrayList<>();

        for (int i = 0; i<colors.length; i++)
            list.add(new Rectangle(xCoordinates[i], yCoordinates[i], widths[i], heights[i], colors[i]));
           /* list.add(new PolygonalShape(new Point[]{new Point(xCoordinates[1],yCoordinates[1]),new Point(xCoordinates[2],yCoordinates[2])
            ,new Point(xCoordinates[3],yCoordinates[3])},colors[5])); */

        return new VectorImage(list, 860, 340);
    }
}