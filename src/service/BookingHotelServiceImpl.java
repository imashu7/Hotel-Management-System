package service;

import org.apache.log4j.Logger;

import dao.BookingHotelDaoImpl;
import model.BookingHotelPojo;
import servlet.Login;

public class BookingHotelServiceImpl {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	private BookingHotelDaoImpl bdi = new BookingHotelDaoImpl();
	public int booking(BookingHotelPojo b1) throws Exception
	{
		LOGGER.info("Inside booking method of BookingHotelServiceImpl in service layer");
		LOGGER.info("Calling booking method from BookingHotelDaoImpl in Dao layer");
			int x = bdi.booking(b1);
//			System.out.println(b1.getUserid());
//			 System.out.println(b1.getCustName());
//				System.out.println(b1.getCustAge());
//				System.out.println(b1.getCustMobNo());
//				System.out.println(b1.getDate());
//				System.out.println(b1.getRoomQuant());
			
			LOGGER.info("Returning value of x");
			return x;
	}

}
