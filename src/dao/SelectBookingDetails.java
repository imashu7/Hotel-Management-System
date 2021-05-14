package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import model.BookingHotelPojo;
import servlet.Login;

public class SelectBookingDetails {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	public static BookingHotelPojo getBookingById(int bookingId) {
		LOGGER.info("Inside getBookingById method ");
		BookingHotelPojo b1=new BookingHotelPojo();
		
		
		try {
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Selecting booking details by booking id");
			PreparedStatement ps = con.prepareStatement("SELECT * from booking where bookingId=?");
			ps.setInt(1, bookingId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				LOGGER.info("Setting booking details inside BookingHotelPojo");
				b1.setBookingId(rs.getInt(1));
				b1.setCustName(rs.getString(2));
				b1.setCustAge(rs.getString(3));
				b1.setCustMobNo(rs.getLong(4));
				b1.setDate(rs.getString(5));
				
				}
			
			LOGGER.info("database connection is closed");
			con.close();
		}catch(Exception ex) {
			LOGGER.error("Exception Occured");
			ex.printStackTrace();}
		
		LOGGER.error("Returning value of b1");
		return b1;
	}
	
	public static List<BookingHotelPojo> getAllBookings(){
		LOGGER.info("Inside getAllBookings method ");
		List<BookingHotelPojo> list=new ArrayList<BookingHotelPojo>();
		
		try {
			
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Selecting booking details by booking table");
			PreparedStatement ps = con.prepareStatement("SELECT * from booking");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				LOGGER.info("Setting booking details in BookingHotelsPojo");
				BookingHotelPojo b1=new BookingHotelPojo();
				b1.setBookingId(rs.getInt(1));
				b1.setHotelID(rs.getInt(2));
				b1.setUserid(rs.getInt(3));
				b1.setCustName(rs.getString(4));
				b1.setCustAge(rs.getString(5));
				b1.setCustMobNo(rs.getLong(6));
				b1.setDate(rs.getString(7));
				b1.setRoomQuant(rs.getString(8));
				list.add(b1);
			}
			LOGGER.info("database connection is closed");
			con.close();
		}catch(Exception ex) {
			
			LOGGER.error("Exception Occured");
			ex.printStackTrace();}
		
		LOGGER.error("Returning list of bookings");
		return list;
	}
}



