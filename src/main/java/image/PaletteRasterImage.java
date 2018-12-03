package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image {

   private List<Color> palette ;
   private int[][] pixels;

    public PaletteRasterImage(Color color, int width, int height){
        super(width, height);
        palette.add(color);

    }

    public PaletteRasterImage(Color[][] pixels){
        super(pixels);

        for ( int indexWidth = 0 ; indexWidth < this.width ; indexWidth++){
            for (int indexHeight = 0 ; indexHeight < this.height ; indexHeight++){
                if ( !isInPaletteColor( pixels[indexWidth][indexHeight] ) ){
                    palette.add( pixels[indexWidth][indexHeight] );
                }
                this.pixels[indexWidth][indexHeight] = palette.indexOf(pixels[indexWidth][indexHeight]);
            }
        }
    }

    public boolean isInPaletteColor(Color color){

        return (palette.contains(color));
    }

    public void createRepresentation(){

        this.palette = new ArrayList<Color>();
        this.pixels = new int[this.width][this.height];
    }

    public void setPixelColor(Color color , int x , int y) {

        if (!isInPaletteColor(color)) this.palette.add(color);
        this.pixels[x][y] = this.palette.indexOf(color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.palette.get(pixels[x][y]);
    }

    public void setPixelsColor(Color[][] pixels){

        for ( int indexHeight = 0 ; indexHeight < pixels[0].length; indexHeight++){
            for (int indexWidth = 0 ;indexWidth < pixels.length ; indexWidth++ ){

                if(!isInPaletteColor(pixels[indexHeight][indexWidth]))palette.add(pixels[indexHeight][indexWidth]);
                this.pixels[indexHeight][indexWidth] = palette.indexOf(pixels[indexHeight][indexWidth]);

            }
        }

    }




}
