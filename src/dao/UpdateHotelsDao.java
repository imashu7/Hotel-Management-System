package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import model.AdminHotelsPojo;
import servlet.Login;

public class UpdateHotelsDao {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	public static int update(AdminHotelsPojo h) {
		
		LOGGER.info("Inside update method which is called by UpdateHotels2 servlet");
		int status=0;
		try {
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Updating hotel details inside database by Admin");
			PreparedStatement ps = con.prepareStatement("UPDATE hoteldetails SET HotelName=?,HotelType=?,TotalRooms=?,AvailableRooms=? where id=?");
			
			ps.setInt(5, h.getHotelID());
			ps.setString(1, h.getHotelName());
			ps.setString(2, h.getHotelType());
			ps.setString(3, h.getTotalRooms());
			ps.setString(4, h.getAvailableRooms());
//			System.out.println(h.getHotelID());
//			 System.out.println(h.getHotelName());
//				System.out.println(h.getHotelType());
//				System.out.println(h.getTotalRooms());
//				System.out.println(h.getAvailableRooms());
			
			
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
