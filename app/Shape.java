package app;

public class Shape {

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

	public boolean rectangleContain(int X, int Y) {

		int x1 = this.getStartX();
		int y1 = this.getStartY();
		int x2 = this.getEndX();
		int y2 = this.getEndY();

		return (((X >= x1 - 1) && (X <= x1 + 1))
				|| ((X >= x2 - 1) && (X <= x2 + 1))
				|| ((Y >= y1 - 1) && (Y <= y1 + 1)) || ((Y >= y2 - 1) && (Y <= y2 + 1)));

	}

	public boolean ptLineDistSq(double px, double py) {
		double x1 = this.getStartX();
		double y1 = this.getStartY();
		double x2 = this.getEndX();
		double y2 = this.getEndY();

		x2 -= x1;
		y2 -= y1;

		px -= x1;
		py -= y1;
		double dotprod = px * x2 + py * y2;

		double projlenSq = dotprod * dotprod / (x2 * x2 + y2 * y2);

		double lenSq = px * px + py * py - projlenSq;
		if (lenSq < 0) {
			lenSq = 0;
		}

		return ((int) lenSq == 0);
	}

	public boolean circleCotain(int X, int Y) {
		boolean result = false;
		int x = this.startX;
		int y = this.startY;
		int x2 = this.getEndX();
		int y2 = this.getEndY();
		int dx = (int) Math.pow((x2 - x), 2);
		int dy = (int) Math.pow((y2 - y), 2);
		int d = (int) Math.sqrt(dx + dy);

		int res = (X - x) * (X - x) + (Y - y) * (Y - y);

		if (res <= ((d * d) + 110) && res >= ((d * d) - 110)) {

			result = true;
		} else {

			result = false;
		}
		return result;
	}
}
