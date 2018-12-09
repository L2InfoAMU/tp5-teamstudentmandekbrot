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

    @Override
    public Color getPixelColor(int x, int y) {

        Point point = new Point(x, y);

        for(Shape theShape : shapes) {
            if(theShape.contains(point)) return theShape.getColor();
        }

        return Color.WHITE; //ou NULL ???
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
