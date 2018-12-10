package image;

import javafx.scene.paint.Color;

public class TriangleRectangle implements Shape {

    private int x, y, width, height;
    private WhatSide whatSide;
    Color color;

    public TriangleRectangle(int x, int y, int width, int height, Color color, WhatSide whatSide){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.whatSide = whatSide;
        this.color = color;
    }

    /**
     * @param point one point
     * @return true if the point is contained in the rectangle triangle
     */
    @Override
    public boolean contains(Point point) {

        switch (whatSide){
            case UPLEFT:
                //todo

            case UPRIGHT:
                //todo

            case DOWNLEFT:
                //todo

            case DOWNRIGHT:
                //todo

            default:
                //todo
        }

        return false;
    }

    /**
     * @return the color of the current rectangle triangle
     */
    @Override
    public Color getColor() {
        return color;
    }
}
