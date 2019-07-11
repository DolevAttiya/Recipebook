package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.SingletonDBConnection;

class SingelToneTest {
	static Connection conn= null;
	
	void openConnection() {
	}
	
	@Test
	void TestOpenWhenclosed()
	{
		try {
			 conn = SingletonDBConnection.getConnection();
			assertFalse(conn.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void TestOpenWhenOpen()
	{
		try {
			 conn = SingletonDBConnection.getConnection();
			 conn.close();
			 conn = SingletonDBConnection.getConnection();
			assertTrue(!conn.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void TestClosewhenNotNull()
	{

		conn = SingletonDBConnection.getConnection();
		SingletonDBConnection.closeConnection();
		try {
			assertFalse(!conn.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
