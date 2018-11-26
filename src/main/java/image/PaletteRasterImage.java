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


    }

    public  void CreateRepresentation(){

        this.palette = new ArrayList<Color>();
        this.pixels = new int[this.width][this.height];
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
