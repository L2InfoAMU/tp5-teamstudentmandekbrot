package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

   private int width;
   private int height;
   private List<Color> palette ;
   private int[][] pixels;

    public PaletteRasterImage(Color color, int width, int height){

        this.width = width;
        this.height = height;
        CreateRepresentation();
        palette.add(color);

    }

    public PaletteRasterImage(Color[][] pixels){
        Matrices.requiresRectangularMatrix(pixels);
        Matrices.requiresNonNull(pixels);
        this.width = pixels[0].length;
        this.height = pixels.length;
        CreateRepresentation();

        for ( int indexInPixelsWidth = 0 ; indexInPixelsWidth < this.width ; indexInPixelsWidth++){
            for (int indexInPixelsHeight = 0 ; indexInPixelsHeight < this.height ; indexInPixelsHeight++){
                if (!isInPaletteColor(pixels[indexInPixelsWidth][indexInPixelsHeight])){
                    palette.add(pixels[indexInPixelsWidth][indexInPixelsHeight]);
                }
            }
        }
    }

    public boolean isInPaletteColor(Color color){

        return (palette.contains(color));
    }

    public  void CreateRepresentation(){

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
        //TODO : implements this method
    }

    private void setPixelsColor(Color color){

        for(int[] integers : pixels){
            for(int integer : integers){
                integer = this.palette.indexOf(color);
            }
        }
    }
    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
