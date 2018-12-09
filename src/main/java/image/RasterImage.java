package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage {

    public int width;
    public int height;

    public RasterImage(int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
    }
    public RasterImage(Color[][] colors){
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonNull(colors);
        this.width = colors.length;
        this.height = colors[0].length;
        createRepresentation();

    }

    public int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public abstract Color getPixelColor(int x, int y);

    public  void setPixelsColor(Color color){

        for (int i = 0 ; i < this.width ; i++) {
            for (int k = 0 ; k < this.height ; k++) {
                setPixelColor(color,i,k);
            }
        }
    }

    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color, int x, int y);

    public void setPixelsColor(Color[][] pixels){

        for (int i = 0 ; i < this.width ; i++) {
            for (int k = 0 ; k < this.height ; k++) {
                setPixelColor(pixels[i][k],i,k);
            }
        }

    }

}