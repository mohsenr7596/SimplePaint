public class Shape {

    private final String color;
    private final String modelShape;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Shape(int startX, int startY, int endX, int endY, String color, String modelShape) {
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
}
