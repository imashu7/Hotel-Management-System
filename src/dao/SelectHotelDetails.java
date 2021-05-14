package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import model.AdminHotelsPojo;
import servlet.Login;

public class SelectHotelDetails {
	
	static final Logger LOGGER=Logger.getLogger(SelectHotelDetails.class);


	public static AdminHotelsPojo getHotelsById(int id) {
		
		LOGGER.info("Inside getHotelsById method which is called by UpdateHotels servlet layer");
		AdminHotelsPojo h=new AdminHotelsPojo();
		
		
		try {
			
			LOGGER.info("Establishing database connection");
			Connection con = DbConnection.getCon();
			LOGGER.info("Selecting hotel details by id");
			PreparedStatement ps = con.prepareStatement("SELECT * from hoteldetails where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				LOGGER.info("Setting hotel details to AdminHotelsPojo class");
				h.setHotelID(rs.getInt(1));
				h.setHotelName(rs.getString(2));
				h.setHotelType(rs.getString(3));
				h.setTotalRooms(rs.getString(4));
				h.setAvailableRooms(rs.getString(5));
				
				}
			LOGGER.info("Database connection is closed");
			con.close();
		}catch(Exception ex) {
			LOGGER.info("Exception occured!!!");
			
			ex.printStackTrace();}
		
		return h;
	}
	
	public static List<AdminHotelsPojo> getAllHotels(){
		LOGGER.info("Inside getAllHotels method which is called in ShowHotels servlet ");
		List<AdminHotelsPojo> list=new ArrayList<AdminHotelsPojo>();
		
		try {
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			LOGGER.info("Selecting Hotel Details from hoteldetails table");
			PreparedStatement ps = con.prepareStatement("SELECT * from hoteldetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AdminHotelsPojo h=new AdminHotelsPojo();
				LOGGER.info("Setting Hotel Details in AdminHotelPojo to show the data");
				h.setHotelID(rs.getInt(1));
				h.setHotelName(rs.getString(2));
				h.setHotelType(rs.getString(3));
				h.setTotalRooms(rs.getString(4));
				h.setAvailableRooms(rs.getString(5));
				list.add(h);
			}
			LOGGER.info("Database connection is closed");
			con.close();
		}catch(Exception ex) {
			LOGGER.info("Exception occured!!!");
			
			ex.printStackTrace();}
		LOGGER.info("Returning list of hotels as a arrayList to ShowHotels servlet");
		return list;
	}
}
