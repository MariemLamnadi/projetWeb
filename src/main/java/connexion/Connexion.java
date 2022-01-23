package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static String login = "odjhptt64s1bwxvx";
    private static String password = "nlo2rq0tplmuc0vd";
    private static String url = "jdbc:mysql://exbodcemtop76rnz.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/sxvy6thtgzsgg939";
    private Connection connection = null;
    private static Connexion instane;

    private Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver introvable");
        } catch (SQLException e) {
            System.out.println("Connexion errror");
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connexion getInstane() {
        if (instane == null) {
            instane = new Connexion();
        }
        return instane;
    }

}
