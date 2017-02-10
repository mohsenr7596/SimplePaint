package app;

public class Rectangle extends Shape {

    public Rectangle(int startX, int startY, int endX, int endY, String color) {
        super(startX, startY, endX, endY, color, "Rectangle");
    }

    @Override
    public boolean containShape(double x, double y) {

        int x1 = getStartX();
        int y1 = getStartY();
        int x2 = getEndX();
        int y2 = getEndY();

        return (((x >= (x1 - 1)) && (x <= (x1 + 1)))
                || ((x >= (x2 - 1)) && (x <= (x2 + 1)))
                || ((y >= (y1 - 1)) && (y <= (y1 + 1))) || ((y >= (y2 - 1)) && (y <= (y2 + 1))));
    }
}
