package viewer;

import image.Image;
import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {

    Color[][] colors;
    Color color;
    int width;
    int height;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        this.color = color;

        for(int index=0; index<colors.length; index++){
            for(int index2=0; index2<colors[0].length; index2++){
                colors[index][index2] = color;
            }
        }
    }

    //index : x     index2 : y
    public BruteRasterImage(Color[][] colors){ this.colors = colors; }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

}
