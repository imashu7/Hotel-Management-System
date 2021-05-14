package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.SelectHotelDetails;
import model.AdminHotelsPojo;


@WebServlet("/UpdateHotels")
public class UpdateHotels extends HttpServlet {
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Inside doGet method of UpdateHotels servlet");
		LOGGER.info("Admin came to update Hotel lists");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update hotels</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		
		LOGGER.info("Calling getHotelsById method from SelectHotelDetails from Dao layer");
		AdminHotelsPojo h=SelectHotelDetails.getHotelsById(id);
		
		
		LOGGER.info("Showing hotel details to Admin");
		out.print("<form action='UpdateHotels2' method='post'>");
		out.print("<table>");
		out.print("<tr><td>HotelID</td><td><input type='hiden' name='HotelID' value='"+h.getHotelID()+"'/></td></tr>");
		out.print("<tr><td>HotelName</td><td><input type='text' name='HotelName' value='"+h.getHotelName()+"'/></td></tr>");
		out.print("<tr><td>HotelType</td><td><input type='text' name='HotelType' value='"+h.getHotelType()+"'/></td></tr>");
		out.print("<tr><td>TotalRooms</td><td><input type='number' name='TotalRooms' value='"+h.getTotalRooms()+"'/></td></tr>");
		out.print("<tr><td>AvailableRooms</td><td><input type='number' name='AvailableRooms' value='"+h.getAvailableRooms()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Update & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
		
		}

	

}
