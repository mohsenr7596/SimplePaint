package app.shapes;

public class Line extends Shape {

    public Line(int startX, int startY, int endX, int endY, String color) {
        super(startX, startY, endX, endY, color, "Line");
    }

    @Override
    public boolean containShape(double px, double py) {
        double x2 = getEndX();
        double y2 = getEndY();

        x2 -= getStartX();
        y2 -= getStartY();

        px = px - getStartX();
        py = py - getStartY();
        double v = px * x2 + py * y2;

        double lenSq = px * px + py * py - (v * v / (x2 * x2 + y2 * y2));
        if (lenSq < 0) {
            lenSq = 0;
        }

        return (int) lenSq == 0;
    }
}
