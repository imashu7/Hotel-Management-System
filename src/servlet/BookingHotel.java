package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.AdminHotelsPojo;
import model.BookingHotelPojo;
import service.BookingHotelServiceImpl;
import model.User;


@WebServlet("/BookingHotel")
public class BookingHotel extends HttpServlet {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("Inside doGet method of BookingHotel servlet");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		BookingHotelServiceImpl bsi = new BookingHotelServiceImpl();
		BookingHotelPojo b1 = new BookingHotelPojo();
		
		
		HttpSession session = request.getSession();
		int uID = (int)session.getAttribute("uID");
		
		AdminHotelsPojo h=new AdminHotelsPojo();
		
		
		LOGGER.info("Taking Booking details from user");
		int HotelID = (int)session.getAttribute("HotelID");
		//System.out.println(HotelID);
		
		String custName=request.getParameter("custName");
		String custAge=request.getParameter("custAge");
		long custMobNo=Long.parseLong(request.getParameter("custMobNo"));
		String date=request.getParameter("date");
		String roomQuant=request.getParameter("roomQuant");
		
//		System.out.println(uID);
//		 System.out.println(custName);
//			System.out.println(custAge);
//			System.out.println(custMobNo);
//			System.out.println(date);
//			System.out.println(roomQuant);
		
		LOGGER.info("Setting booking details to BookingHotelPojo");
		
	    b1.setHotelID(HotelID);
		b1.setUserid(uID);
		b1.setCustName(custName);
		b1.setCustAge(custAge);
		b1.setCustMobNo(custMobNo);
		b1.setDate(date);
		b1.setRoomQuant(roomQuant);
		
		int flag;
		
		try {
			
			LOGGER.info("Calling booking method from BookingHotelServiceImpl in service layer");
			flag = bsi.booking(b1);
		}
		catch (Exception e)
		{
			LOGGER.error("Exception Occured");
			e.printStackTrace();
		}
		
	}

}
