package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import model.AdminHotelsPojo;
import servlet.Login;

public class AdminHotelsDaoImpl {
	static final Logger LOGGER=Logger.getLogger(Login.class);
	public static int save(AdminHotelsPojo h) {
		LOGGER.info("Inside save method which is called by AdimHotels servlet layer");
		int status=0;
		try
		{
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Inserting hotel details in database by Admin");
			PreparedStatement ps = con.prepareStatement
					("INSERT INTO hoteldetails(HotelName,HotelType,TotalRooms,AvailableRooms) VALUES (?,?,?,?)");
			
			
			ps.setString(1, h.getHotelName());
			ps.setString(2, h.getHotelType());
			ps.setString(3, h.getTotalRooms());
			ps.setString(4, h.getAvailableRooms());
//		    System.out.println(h.getHotelName());
//			System.out.println(h.getHotelType());
//			System.out.println(h.getTotalRooms());
//			System.out.println(h.getAvailableRooms());
			
			status=ps.executeUpdate();
			
			LOGGER.info("Database connection is closed");
			con.close();
		
		}catch(Exception ex) {
			LOGGER.info("Exception occured!!!");
			ex.printStackTrace();}
		
		return status;
	}
	
}
