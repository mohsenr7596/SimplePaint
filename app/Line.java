package app;

public class Line extends Shape {

    public Line(int startX, int startY, int endX, int endY, String color) {
        super(startX, startY, endX, endY, color, "Line");
    }

    @Override
    public boolean containShape(int px, int py) {
        double x2 = getEndX();
        double y2 = getEndY();

        x2 -= getStartX();
        y2 -= getStartY();

        px -= getStartX();
        py -= getEndY();
        double dotprod = px * x2 + py * y2;

        double projlenSq = dotprod * dotprod / (x2 * x2 + y2 * y2);

        double lenSq = px * px + py * py - projlenSq;
        if (lenSq < 0) {
            lenSq = 0;
        }

        return ((int) lenSq == 0);
    }
}
