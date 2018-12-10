package image;

import java.awt.*;
import java.util.HashMap;
import javafx.scene.paint.Color ;

public class SparseRasterImage extends RasterImage implements Image{

  private HashMap<Point, Color> colors ;

     public SparseRasterImage(Color color,int width, int height){
         super(width, height);
         for ( int i = 0 ; i < this.width ; i++){
             for(int k = 0 ; k < this.height ; k++){
                 this.colors.put(new Point(i,k),color);
             }
         }

     }
     public SparseRasterImage(Color[][] colors){
         super(colors.length,colors[0].length);
         for ( int i = 0 ; i < this.width ; i++){
             for(int k = 0 ; k < this.height ; k++){
                 this.colors.put(new Point(i,k),colors[i][k]);
             }
         }
     }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.colors.getOrDefault(new Point(x,y),Color.WHITE);
    }

    @Override
    public void createRepresentation() {
     this.colors = new HashMap<>();
    }

    @Override
    public void setPixelColor(Color color, int x, int y) {
         Point a = new Point(x,y);
        if (this.colors.containsKey(a)){

            this.colors.replace(a,color);
        }
        else{
            this.colors.put(a,color);
        }
    }
}
