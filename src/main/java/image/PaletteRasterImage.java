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
        this.width = pixels.length;
        this.height = pixels[0].length;
        CreateRepresentation();

        for ( int indexWidth = 0 ; indexWidth < this.width ; indexWidth++){
            for (int indexHeight = 0 ; indexHeight < this.height ; indexHeight++){
                if (!isInPaletteColor(pixels[indexWidth][indexHeight])){
                    palette.add(pixels[indexWidth][indexHeight]);
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

        for ( int i = 0 ; i < pixels[0].length; i++){
            for (int j = 0 ;j < pixels.length ; j++ ){

                if(!isInPaletteColor(pixels[i][j]))palette.add(pixels[i][j]);
                this.pixels[i][j] = palette.indexOf(pixels[i][j]);

            }
        }




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
