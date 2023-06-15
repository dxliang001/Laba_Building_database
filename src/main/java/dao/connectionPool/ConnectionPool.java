package dao.connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        // make sure to replace with your DB details
        dataSource.setUrl("jdbc:mysql://18.197.182.199:3306/Alex_building_laba");
        dataSource.setUsername("root");
        dataSource.setPassword("devintern");


        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxTotal(50);
        dataSource.setMaxWaitMillis(30000); 
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
