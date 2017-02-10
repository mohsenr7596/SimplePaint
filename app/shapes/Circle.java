package app.shapes;

public class Circle extends Shape {

    public Circle(int startX, int startY, int endX, int endY, String color) {
        super(startX, startY, endX, endY, color, "Circle");
    }

    @Override
    public boolean containShape(double x, double y) {

        int dx = (int) Math.pow((getEndX() - getStartX()), 2);
        int dy = (int) Math.pow((getEndY() - getStartY()), 2);
        int d = (int) Math.sqrt(dx + dy);

        int res = (int) ((x - getStartX()) * (x - getStartX()) + (y - getStartY()) * (y - getStartY()));

        return res <= ((d * d) + 110) && res >= ((d * d) - 110);
    }
}
