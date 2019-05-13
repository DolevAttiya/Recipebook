import java.sql.*;
public class Main {
public static void  main(String args[]) {
	Connection con =dbconnector();
	if(con!=null)
	System.out.println("Open Database");

}
	public static  Connection dbconnector() {
	Connection con=null;
	try {
		Class.forName("orge.sqlite.JDBC");
		con=DriverManager.getConnection("jdbc:sqlite:database.db");
		System.out.println("Open Database");
		return con;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
	
}

}
