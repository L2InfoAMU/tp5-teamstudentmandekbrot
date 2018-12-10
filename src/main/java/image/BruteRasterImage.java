package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage implements Image  {

    private Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        super(width, height);

        for(int index=0; index<width; index++){
            for(int index2=0; index2<height; index2++){
                colors[index][index2] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors){
        super(colors);
        this.colors = colors.clone();
    }

    /**
     * @param x
     * @param y
     * @return a color from the specific coordinates
     */
    @Override
    public Color getPixelColor(int x, int y){ return colors[x][y]; }

    /**
     * Create a array with specific index limit
     */
    public void createRepresentation(){
        colors = new Color[width][height];
    }

    /**
     * Set a color that replace the current color at the x,y coordinates
     * @param color
     * @param x
     * @param y
     */
    public void setPixelColor(Color color , int x , int y){
        this.colors[x][y] = color ;
    }




}
