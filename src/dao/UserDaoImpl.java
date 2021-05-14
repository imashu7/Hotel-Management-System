package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import model.User;
import servlet.Login;


public class UserDaoImpl implements UserDao 
{

	static final Logger LOGGER=Logger.getLogger(Login.class);
	public int signup(User u1) throws Exception
	{
		
		
		LOGGER.info("Inside signup method which is called in UserServiceImpl");
		int x = 0;

		try{
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Inserting user data into database");
			PreparedStatement ps = con.prepareStatement("INSERT INTO login(UserName, PhoneNumber, EmailID, Password) VALUES(?,?,?,?)");
			ps.setString(1, u1.getName());
			ps.setLong(2, u1.getPhoneNumber());
			ps.setString(3, u1.getEmailID());
			ps.setString(4, u1.getPassword());
			x = ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured!!!");
			e.getMessage();
		}
		finally
		{
			LOGGER.info("Database connection is closed");
			DbConnection.conClose();
		}
		return x;
	}
	
	public int[] login(User u1) throws Exception
	{
		LOGGER.info("Inside login method which is called in UserServiceImpl");
		int[] flag = {0,0};
		String Name = u1.getName();
		String Password = u1.getPassword();
		try{
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			LOGGER.info("Selecting user id from user database");
			ResultSet rs = st.executeQuery("SELECT Userid FROM login Where Username = '"+ Name +"' AND Password = '"+Password+"'");
			if(rs.next())
			{
				flag[0]= 1;
				flag[1]=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			LOGGER.error("Exception Occured!!!");
			e.printStackTrace();
		}
		finally
		{
			LOGGER.info("Database connection is closed");
			DbConnection.conClose();
		}
		LOGGER.info("Sending value of flag to UserServiceImpl service layer");
		return flag;
	}

	
}

