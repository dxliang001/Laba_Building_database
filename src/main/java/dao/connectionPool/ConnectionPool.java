package dao.connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();

        // Load properties from the db.properties file
        Properties dbProperties = new Properties();
        try (InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find database.properties");
            } else {
                // load a properties file from class path
                dbProperties.load(input);

                // Set DB details from properties
                dataSource.setUrl(dbProperties.getProperty("DB_URL"));
                dataSource.setUsername(dbProperties.getProperty("DB_USERNAME"));
                dataSource.setPassword(dbProperties.getProperty("DB_PASSWORD"));

                dataSource.setMinIdle(5);
                dataSource.setMaxIdle(20);
                dataSource.setMaxTotal(50);
                dataSource.setMaxWaitMillis(30000);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error getting database connection", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection");
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        try {
            dataSource.close();
        } catch (SQLException e) {
            System.out.println("Error shutting down connection pool");
            e.printStackTrace();
        }
    }
}
