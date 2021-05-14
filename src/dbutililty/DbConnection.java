package dbutililty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
	private static Connection con = null;
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydab", "root", "Ashutosh@123");

		return con;
	}

	public static void  conClose() throws SQLException
	{
		if(con!=null)
		{
			con.close();
		}
	}
}

