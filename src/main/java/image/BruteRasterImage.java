package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage implements Image{

    Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        super(width, height);

        for(int index=0; index<width; index++){
            for(int index2=0; index2<height; index2++){
                colors[index][index2] = color;
            }
        }
    }

    //index : x     index2 : y
    public BruteRasterImage(Color[][] colors){

        super(colors);

        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonNull(colors);
        this.colors = colors.clone();
    }

    @Override
    public Color getPixelColor(int x, int y){ return colors[x][y]; }

    public void createRepresentation(){
        colors = new Color[width][height];
    }

    public void setPixelColor(Color color , int x , int y){
        this.colors[x][y] = color ;
    }

    public void setPixelsColor(Color[][] pixels){ this.colors = pixels.clone(); }


}
