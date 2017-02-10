package app;

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

    private boolean rectangleContain(int x, int y) {

        int x1 = this.getStartX();
        int y1 = this.getStartY();
        int x2 = this.getEndX();
        int y2 = this.getEndY();

        return (((x >= (x1 - 1)) && (x <= (x1 + 1)))
                || ((x >= (x2 - 1)) && (x <= (x2 + 1)))
                || ((y >= (y1 - 1)) && (y <= (y1 + 1))) || ((y >= (y2 - 1)) && (y <= (y2 + 1))));

    }

    private boolean ptLineDistSq(double px, double py) {

        double x2 = this.getEndX();
        double y2 = this.getEndY();

        x2 -= startX;
        y2 -= startY;

        px -= startX;
        py -= startY;
        double dotprod = px * x2 + py * y2;

        double projlenSq = dotprod * dotprod / (x2 * x2 + y2 * y2);

        double lenSq = px * px + py * py - projlenSq;
        if (lenSq < 0) {
            lenSq = 0;
        }

        return ((int) lenSq == 0);
    }

    public boolean circleCotain(int x, int y) {

        int dx = (int) Math.pow((endX - startX), 2);
        int dy = (int) Math.pow((endY - startY), 2);
        int d = (int) Math.sqrt(dx + dy);

        int res = (x - startX) * (x - startX) + (y - startY) * (y - startY);

        return res <= ((d * d) + 110) && res >= ((d * d) - 110);
    }

    public abstract boolean containShape(int x, int y);
}
