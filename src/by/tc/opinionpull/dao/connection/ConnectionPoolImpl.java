package by.tc.opinionpull.dao.connection;

import by.tc.opinionpull.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPoolImpl implements ConnectionPool {

    private static final String PATH_TO_PROPERTIES = "resources.db";
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String USE_UNICODE = "useUnicode";
    private static final String CHARACTER_ENCODING = "characterEncoding";
    private static final String AUTO_RECONNECT = "autoReconnect";

    private BlockingQueue<Connection> availableConns = new LinkedBlockingDeque<Connection>();
    private BlockingQueue<Connection> usedConns = new LinkedBlockingDeque<Connection>();
    private String url;
    private Properties properties = new Properties();



    public ConnectionPoolImpl(){
	        ResourceBundle resourceBundle = ResourceBundle.getBundle(PATH_TO_PROPERTIES);
	        try {
		        Class.forName(resourceBundle.getString(DRIVER));

		        this.url = resourceBundle.getString(URL);
		        this.properties.put(USER,resourceBundle.getString(USER));
		        this.properties.put(PASSWORD, resourceBundle.getString(PASSWORD));
		        this.properties.put(USE_UNICODE, resourceBundle.getString(USE_UNICODE));
		        this.properties.put(CHARACTER_ENCODING, resourceBundle.getString(CHARACTER_ENCODING));
		        this.properties.put(AUTO_RECONNECT, resourceBundle.getString(AUTO_RECONNECT));

	        } catch (ClassNotFoundException e) {
		        e.printStackTrace();
	        }




    }

    private  Connection getConnection() throws DAOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,properties);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return conn;
    }

    @Override
    public  Connection retrieve() throws DAOException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.element();
            availableConns.remove(newConn);
        }
        usedConns.add(newConn);
        return newConn;
    }

    @Override
    public void putback(Connection c) throws DAOException {
        if (c != null) {
            if (usedConns.remove(c)) {
                availableConns.add(c);
            } else {
                throw new DAOException("Connection not in the used");
            }
        }

    }

    @Override
    public void closeAll() throws DAOException {
        for (Connection cn : availableConns){
            try {
                cn.close();
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }
        for (Connection cn : usedConns){
            try {
                cn.close();
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }
    }
}
