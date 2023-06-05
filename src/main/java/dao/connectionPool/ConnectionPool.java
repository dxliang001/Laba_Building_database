package dao.connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        // make sure to replace with your DB details
        dataSource.setUrl("jdbc:mysql://localhost:3306/laba_test");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        dataSource.setMinIdle(5); // the minimum number of connections to create and maintain
        dataSource.setMaxIdle(20); // the maximum number of idle connections that can be kept in the pool
        dataSource.setMaxTotal(50); // the maximum number of active connections that can be allocated at the same time
        dataSource.setMaxWaitMillis(30000); // the maximum number of milliseconds that the pool will wait for a connection to be returned before throwing an exception
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

}
