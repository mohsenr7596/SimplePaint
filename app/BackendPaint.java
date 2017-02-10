package app;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BackendPaint {

    private final List<Shape> shapes = new ArrayList<>();
    private final String username;

    public BackendPaint(String username) {
        this.username = username;
    }

    public void drawShape(Shape shape, Graphics g, boolean add) {

        switch (shape.getModelShape()) {
            case "Line":
                defineColor(shape.getColor(), g)
                        .drawLine(shape.getStartX(),
                                shape.getStartY(),
                                shape.getEndX(),
                                shape.getEndY());
                break;
            case "Circle":
                drawCircle(shape.getStartX(),
                        shape.getStartY(),
                        shape.getEndX(),
                        shape.getEndY(),
                        defineColor(shape.getColor(), g));
                break;
            case "Rectangle":
                drawRectangle(shape.getStartX(),
                        shape.getStartY(),
                        shape.getEndX(),
                        shape.getEndY(),
                        defineColor(shape.getColor(), g));
                break;

            default:
                return;
        }
        if (add) {
            shapes.add(shape);
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, Graphics g) {

        if (x1 > x2 && y1 > y2) {
            g.drawRect(x2, y2, x1 - x2, y1 - y2);
        } else if (x1 > x2) {
            g.drawRect(x2, y1, x1 - x2, y2 - y1);
        } else if (y1 > y2) {
            g.drawRect(x1, y2, x2 - x1, y1 - y2);
        } else {
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        }
    }

    public void drawCircle(int x1, int y1, int x2, int y2, Graphics g) {

        int dx = (int) Math.pow((x2 - x1), 2);
        int dy = (int) Math.pow((y2 - y1), 2);
        int d = (int) Math.sqrt(dx + dy);
        g.drawOval(x1 - d, y1 - d, 2 * d, 2 * d);
    }

    public Graphics defineColor(String s, Graphics g) {

        switch (s) {
            case "Black":
                g.setColor(Color.BLACK);
                break;
            case "Red":
                g.setColor(Color.RED);
                break;
            case "Green":
                g.setColor(Color.GREEN);
                break;
            case "Blue":
                g.setColor(Color.BLUE);
                break;
            default:
                g.setColor(Color.black);
        }
        return g;
    }

    private void addShapesToDataBase() {
        DatabaseConnectivity.addPaints(shapes, username);
    }

    public List<Shape> getList() {
        return DatabaseConnectivity.getPaints(username);
    }

    public boolean exitConfirm() {

        Object[] option = {"Yes and Save", "Don't Save", "No"};
        int n = JOptionPane.showOptionDialog(null, "Are you sure to exit ?",
                "", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[2]);
        if (n == JOptionPane.YES_OPTION) {
            addShapesToDataBase();
            LoginClass.showForm();
            return true;
        } else if (n == JOptionPane.NO_OPTION) {
            LoginClass.showForm();
            return true;
        }
        return false;
    }
}
