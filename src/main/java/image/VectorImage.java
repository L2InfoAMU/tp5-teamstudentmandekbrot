package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image{

    private List<Shape> shapes;
    private int width, height;

    public VectorImage(List<Shape> shapes, int width, int height){
        this.shapes = shapes;
        this.width = width;
        this.height =  height;
    }

    /**
     * @param x one coordinate
     * @param y one coordinate
     * @return the color of the shape containing the point. If the point isn't in the shape, return the white color
     */
    @Override
    public Color getPixelColor(int x, int y) {

        Point point = new Point(x, y);

        for(Shape theShape : shapes) {
            if(theShape.contains(point)) return theShape.getColor();
        }

        return Color.WHITE;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected int setWidth(int width){
        this.width = width;
        return width;
    }


    protected int setHeight(int height){
        this.height = height;
        return height;
    }

}
