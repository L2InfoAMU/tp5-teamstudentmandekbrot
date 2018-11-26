package image;

import javafx.scene.paint.Color;

public class PaletteRasterImage implements Image {

    int width;
    int height;
    Color[][] pixels;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;

        for(int indexWidth=0; indexWidth<width; indexWidth++){
            for(int indexHeight=0; indexHeight<height; indexHeight++){
                pixels[indexWidth][indexHeight] = color;
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels){
        this.pixels = pixels.clone();
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
