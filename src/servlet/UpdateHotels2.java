package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.AdminHotelsDaoImpl;
import model.AdminHotelsPojo;
import dao.UpdateHotelsDao;


@WebServlet("/UpdateHotels2")
public class UpdateHotels2 extends HttpServlet {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("Inside dopost method of UpdateHotels2 servlet");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		LOGGER.info("Getting new data from Admin to update hotel details");
		int HotelID=Integer.parseInt(request.getParameter("HotelID"));
		String HotelName=request.getParameter("HotelName");
		String HotelType=request.getParameter("HotelType");
		String TotalRooms=request.getParameter("TotalRooms");
		String AvailableRooms=request.getParameter("AvailableRooms");
		
//		System.out.println(HotelID);
//		System.out.println(HotelName);
//		System.out.println(HotelType);
//		System.out.println(TotalRooms);
//		System.out.println(AvailableRooms);
		AdminHotelsPojo h=new AdminHotelsPojo();
		
		LOGGER.info("Setting hotel details inside AdminHotelsPojo");
		h.setHotelID(HotelID);
		h.setHotelName(HotelName);
		h.setHotelType(HotelType);
		h.setTotalRooms(TotalRooms);
		h.setAvailableRooms(AvailableRooms);
		
		int status = 0;
		try {
			
			LOGGER.info("Calling update function from UpdateHotelsDao");
			status = UpdateHotelsDao.update(h);
		} catch (Exception e) {
			LOGGER.info("Exception occured!!!");
			
			e.printStackTrace();
		} 
		LOGGER.info("Checking status value returned by UpdateHotelDao and if greater than 0 then entring if block");
		if(status>0)
		{
			
			LOGGER.info("Showing all Hotel Details to Admin");
			response.sendRedirect("ShowHotels");
		}else {
			
			LOGGER.info("Hotel Details not updated");
			out.println("Sorry! unable to update record");
		}
		out.close();
	}

}
