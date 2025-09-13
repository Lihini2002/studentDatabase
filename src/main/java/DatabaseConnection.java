import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnection {

//	    private static final String CONFIG_FILE = "student-management/src/config.properties";
	    private static final String CONFIG_FILE = "src/config.properties";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load properties file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_FILE);
            props.load(fis);

            // Get DB properties
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

        } catch (IOException e) {
            System.out.println("Failed to load config.properties!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }
        return connection;
    }
}
