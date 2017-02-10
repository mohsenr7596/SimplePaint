package app;

import java.awt.geom.Line2D;

public abstract class Shape {

    private String color;
    private final String modelShape;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Shape(int startX, int startY, int endX, int endY, String color,
                 String modelShape) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        this.modelShape = modelShape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelShape() {
        return modelShape;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public abstract boolean containShape(double x, double y);
}
