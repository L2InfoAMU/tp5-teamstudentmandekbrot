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


    /**
     * @return the current width
     */
    public int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the current height
     */
    public int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param x
     * @param y
     * @return a color from the specific coordinates
     */
    public abstract Color getPixelColor(int x, int y);

    /**
     * Apply the param color to all coordinates in the matrice
     * @param color
     */
    public  void setPixelsColor(Color color){

        for (int i = 0 ; i < this.width ; i++) {
            for (int k = 0 ; k < this.height ; k++) {
                setPixelColor(color,i,k);
            }
        }
    }

    /**
     * Create a array with specific index limit
     */
    public abstract void createRepresentation();

    /**
     * Replace the color to the specific coordinates (x, y) with the param color
     * @param color
     * @param x
     * @param y
     */
    public abstract void setPixelColor(Color color, int x, int y);

    /**
     * Apply the color[i][j] of the array pixels to the coordinates (i,j) in the matrice
     * This method use setPixelColor(Color color, int x, int y) to apply at the specific coordinates
     * @param pixels
     */
    public void setPixelsColor(Color[][] pixels){

        for (int i = 0 ; i < this.width ; i++) {
            for (int k = 0 ; k < this.height ; k++) {
                setPixelColor(pixels[i][k],i,k);
            }
        }

    }

}