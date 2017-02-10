package app.model;

import app.shapes.Circle;
import app.shapes.Line;
import app.shapes.Rectangle;
import app.shapes.Shape;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectivity {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/PaintProject?autoReconnect=true&useSSL=false";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String USER_DB = "root";
    private static final String PASS_DB = "toor";

    private static Connection conn;
    private static Statement stmt;

    private DatabaseConnectivity() {
    }

    private static void initConnection() {

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_DB, PASS_DB);
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    private static void closeConnection() {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

    }

    public static int checkUserPass(String user, String pass) {
        initConnection();

        String sql = "SELECT *\n" + "FROM `Username`\n"
                + "WHERE Username.User = '" + user + "';";

        try (ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                if (rs.getString(2).equals(pass)) {
                    return 1;
                }
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        closeConnection();

        return -1;
    }

    public static List<Shape> getPaints(String tbName) {

        initConnection();

        List<Shape> list = new ArrayList<>();

        String sql = "SELECT *\n" + "FROM paintproject." + tbName + ";";

        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                Shape shape;
                switch (rs.getString(6)) {
                    case "Line":
                        shape = new Line(Integer.parseInt(rs.getString(1)),
                                Integer.parseInt(rs.getString(2)),
                                Integer.parseInt(rs.getString(3)),
                                Integer.parseInt(rs.getString(4)),
                                rs.getString(5));
                        break;

                    case "Circle":
                        shape = new Circle(Integer.parseInt(rs.getString(1)),
                                Integer.parseInt(rs.getString(2)),
                                Integer.parseInt(rs.getString(3)),
                                Integer.parseInt(rs.getString(4)),
                                rs.getString(5));
                        break;

                    case "Rectangle":
                        shape = new Rectangle(Integer.parseInt(rs.getString(1)),
                                Integer.parseInt(rs.getString(2)),
                                Integer.parseInt(rs.getString(3)),
                                Integer.parseInt(rs.getString(4)),
                                rs.getString(5));
                        break;

                    default:
                        continue;

                }
                list.add(shape);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        closeConnection();

        return list;
    }

    public static void deletePaint(String username, Shape shape) {
        initConnection();

        String sql = "DELETE\n" +
                "FROM\n" +
                "  `" + username + "`\n" +
                "WHERE\n" +
                "  `intX` = '" + shape.getStartX() + "' AND `intY` = '" + shape.getStartY() + "' AND `intEndX` = '" + shape.getEndX() + "' AND `intEndY` = '" + shape.getEndY() + "' AND `modol` = '" + shape.getModelShape() + "';";


        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        closeConnection();

    }

    public static void addPaints(List<Shape> list, String user) {

        initConnection();

        for (int i = 0; i < list.size(); i++) {

            Shape shape = list.get(i);

            String sql = "INSERT INTO paintproject."
                    + user
                    + " (`intX`, `intY`, `intEndX`, `intEndY`, `color`, `modol`)\n"
                    + "VALUES ('" + shape.getStartX() + "', '"
                    + shape.getStartY() + "', '" + shape.getEndX() + "', '"
                    + shape.getEndY() + "', '" + shape.getColor() + "', '"
                    + shape.getModelShape() + "');";

            try {
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }

        closeConnection();
    }

    private static int createUser(String user, String pass) {

        initConnection();

        String sql = "CREATE TABLE `paintproject`.`" + user + "` (\n" +
                "  `intX`    VARCHAR(45) NOT NULL,\n" +
                "  `intY`    VARCHAR(45) NOT NULL,\n" +
                "  `intEndX` VARCHAR(45) NOT NULL,\n" +
                "  `intEndY` VARCHAR(45) NOT NULL,\n" +
                "  `color`   VARCHAR(45) NOT NULL,\n" +
                "  `modol`   VARCHAR(45) NOT NULL,\n" +
                "  `id`      INT         NOT NULL AUTO_INCREMENT,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ")\n" +
                "  ENGINE = MyISAM\n" +
                "  CHARSET = utf8\n" +
                "  COLLATE utf8_general_ci;";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
            return -1;
        }

        sql = "INSERT INTO `username` (`User`, `Pass`) VALUES ('" + user
                + "', '" + pass + "');";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
            return -1;
        }

        closeConnection();

        return 1;
    }

    public static void changeColor(String username, Shape shape) {

        initConnection();

        String sql = "UPDATE `" + username + "`\n" +
                "SET `color` = '" + shape.getColor() + "'\n" +
                "WHERE\n" +
                "  `intX` = '" + shape.getStartX() + "' AND `intY` = '" + shape.getStartY() + "' AND `intEndX` = '" + shape.getEndX() + "' AND `intEndY` = '" + shape.getEndY() + "' AND `modol` = '" + shape.getModelShape() + "';";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        closeConnection();

    }
}
