package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import servlet.Login;

public class DeleteHotelsDao {
	static final Logger LOGGER=Logger.getLogger(Login.class);
	public static int delete(int id) {
		LOGGER.info("Inside delete method which is called by DeleteHotels servlet");
		int status=0;
		try {
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Deleting hotel details inside database by Admin");
			PreparedStatement ps = con.prepareStatement("DELETE from hoteldetails where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
			LOGGER.info("Database connection is closed");
			con.close();
		}catch(Exception ex) {
			LOGGER.info("Exception occured!!!");
			ex.printStackTrace();}
		
		LOGGER.info("Returning status value");

		return status;
	}

}

