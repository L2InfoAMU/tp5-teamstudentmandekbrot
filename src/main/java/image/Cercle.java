package image;

import javafx.scene.paint.Color;

public class Cercle implements Shape {

    double radius;
    int x, y;
    Color color;

    public Cercle(int x, int y, double radius, Color color){
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /**
     * @param point
     * @return a boolean if the point is contained in the geometric shape
     */
    @Override
    public boolean contains(Point point) {
        return (Math.sqrt( (this.x - point.x)*(this.x - point.x) + (this.y - point.y)*(this.y - point.y)) <= radius*radius);
    }

    /**
     *
     * @return the color of the current geometric shape
     */
    @Override
    public Color getColor() {
        return color;
    }
}
