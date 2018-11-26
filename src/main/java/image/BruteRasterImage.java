package image;

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
        createRepresentation();

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
    public Color getPixelColor(int x, int y){ return colors[x][y]; }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void createRepresentation(){
        colors = new Color[width][height];
    }

    public void setPixelColor(Color color , int x , int y){
        this.colors[x][y] = color ;
    }

    public void setPixelsColor(Color[][] pixels){ this.colors = pixels.clone(); }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private void setPixelsColor(Color color){
        for(int indexWidth=0; indexWidth<width; indexWidth++){
            for(int indexHeight=0; indexHeight<height; indexHeight++){
                setPixelColor(color, indexWidth, indexHeight);
            }
        }
    }

}
