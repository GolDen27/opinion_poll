package by.tc.opinionpull.dao.connection;

public class ConnectionFactory {

    private static final ConnectionFactory instance = new ConnectionFactory();

    private final ConnectionPool connectionPool = new ConnectionPoolImpl();

    private ConnectionFactory() {}

    public static ConnectionFactory getInstance(){
        return instance;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
