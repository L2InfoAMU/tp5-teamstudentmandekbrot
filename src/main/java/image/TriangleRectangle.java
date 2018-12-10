package image;

import javafx.scene.paint.Color;

public class TriangleRectangle implements Shape {

    int x, y, width, height;
    WhatSide whatSide;

    public TriangleRectangle(int x, int y, int width, int height, WhatSide whatSide){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.whatSide = whatSide;
    }

    @Override
    public boolean contains(Point point) {

        switch (whatSide){
            case UPLEFT:



            case UPRIGHT:

            case DOWNLEFT:

            case DOWNRIGHT:

            default:
        }

        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
