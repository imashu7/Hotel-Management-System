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


@WebServlet("/AdminHotels")
public class AdminHotels extends HttpServlet {
	
	static final Logger LOGGER=Logger.getLogger(AdminHotels.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    LOGGER.info("Inside dopost method of login servlet");
		
		    response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			LOGGER.info("Getting Hotel Details from Admin");
			String HotelName=request.getParameter("HotelName");
			String HotelType=request.getParameter("HotelType");
			String TotalRooms=request.getParameter("TotalRooms");
			String AvailableRooms=request.getParameter("AvailableRooms");
			
//			System.out.println(HotelName);
//			System.out.println(HotelType);
//			System.out.println(TotalRooms);
//			System.out.println(AvailableRooms);
			AdminHotelsPojo h=new AdminHotelsPojo();
			//System.out.println(h.getHotelName());
			
			LOGGER.info("Setting Hotel details in AdminHotelPojo class ");
			h.setHotelName(HotelName);
			h.setHotelType(HotelType);
			h.setTotalRooms(TotalRooms);
			h.setAvailableRooms(AvailableRooms);
			
			LOGGER.info("calling the method save from AdminHotelsDaoImpl");
			int status=AdminHotelsDaoImpl.save(h);
			//System.out.println(status);
			if(status>0) {
				LOGGER.info("Hotel details saved sucessfully");
				out.print("<p>Record saved successfully</p>");
				request.getRequestDispatcher("Hotel.html").include(request, response);
				
			}
			else {
				LOGGER.error("Unable to save hotel details");
				out.print("sorry! unable to save record");
			}
		}
		
	}


