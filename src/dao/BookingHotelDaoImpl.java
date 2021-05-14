package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import dbutililty.DbConnection;
import model.BookingHotelPojo;
import servlet.Login;

public class BookingHotelDaoImpl {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	public int booking(BookingHotelPojo b1) throws Exception
	{
		LOGGER.info("Inside booking method of BookingHotelServiceImpl in service layer");
		int x = 0;

		try{
			LOGGER.info("Connection with database is establishing");
			Connection con = DbConnection.getCon();
			
			LOGGER.info("Inserting hotel details inside database by User");
			PreparedStatement ps = con.prepareStatement("INSERT INTO booking(id,UserID,custName, custAge, custMobNo, date,roomQuant) VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, b1.getHotelID());
			ps.setInt(2, b1.getUserid());
			ps.setString(3, b1.getCustName());
			ps.setString(4, b1.getCustAge());
			ps.setLong(5, b1.getCustMobNo());
			ps.setString(6, b1.getDate());
			ps.setString(7, b1.getRoomQuant());
			
//			System.out.println(b1.getHotelID());
//			System.out.println(b1.getUserid());
//			 System.out.println(b1.getCustName());
//				System.out.println(b1.getCustAge());
//				System.out.println(b1.getCustMobNo());
//				System.out.println(b1.getDate());
//				System.out.println(b1.getRoomQuant());
				
			x = ps.executeUpdate();
		}
		catch(Exception e)
		{
			LOGGER.error("Exception Occured");
			e.getMessage();
		}
		finally
		{
			LOGGER.info("database connection is closed");
			DbConnection.conClose();
		}
		
		LOGGER.info("Returning the value of x");
		return x;
	}

}
