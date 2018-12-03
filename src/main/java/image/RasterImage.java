package image;

import javafx.scene.paint.Color;

import java.awt.*;

public abstract class RasterImage {

    int width;
    int height;

    public RasterImage(int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
    }

    public RasterImage(Color[][] colors){
        this.height = colors[0].length ;
        this.width = colors.length ;
    }

    public int getWidth() { return this.width; }

    public int getHeight() {
        return this.height;
    }

    protected void setWidth(int width) { this.width = width; }

    protected void setHeight(int height) { this.height = height; }

    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color , int x , int y);

    public abstract void setPixelsColor(Color[][] pixels);

    public abstract Color getPixelColor(int x, int y);

    public abstract void setPixelsColor(Color color);


}
