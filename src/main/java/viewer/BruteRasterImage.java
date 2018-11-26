package viewer;

import image.Image;
import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {

    Color[][] colors;
    int width;
    int height;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        colors = new Color[width][height];

        for(int index=0; index<width; index++){
            for(int index2=0; index2<height; index2++){
                colors[index][index2] = color;
            }
        }
    }

    //index : x     index2 : y
    public BruteRasterImage(Color[][] colors){

        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonNull(colors);
        this.colors = colors.clone();

        this.height = this.colors.length ;
        this.width = this.colors[0].length ;
    }

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
