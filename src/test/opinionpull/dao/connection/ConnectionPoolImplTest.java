package test.opinionpull.dao.connection;

import by.tc.opinionpull.dao.connection.ConnectionPoolImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionPoolImplTest {
	@Test
	public void retrieve() throws Exception {
		ConnectionPoolImpl connectionPool = new ConnectionPoolImpl();
		Connection connection = connectionPool.retrieve();
		Assert.assertTrue(connection.isValid(0));
	}

	@Test
	public void putback() throws Exception {
		ConnectionPoolImpl connectionPool = new ConnectionPoolImpl();
		Connection connection = connectionPool.retrieve();
		connectionPool.putback(connection);


	}

	@Test
	public void closeAll() throws Exception {
		ConnectionPoolImpl connectionPool = new ConnectionPoolImpl();
		for(int i=0; i<10; i++) {
			connectionPool.retrieve();
		}
		connectionPool.closeAll();
	}

}