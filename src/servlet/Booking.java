package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.SelectHotelDetails;
import model.AdminHotelsPojo;
import model.BookingHotelPojo;


@WebServlet("/Booking")
public class Booking extends HttpServlet {
	
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("Inside doGet method of Booking servlet");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		 out.println("<style>");
		
		  out.println("table,th,td {");        
		  out.println("color:orangered;");
		  
		  out.println("border: 1px solid black;");
		  out.println("width:30%;");
		  out.println("text-align:center;");
		  out.println("background-color:rgba(0,0,0,0.5)");
		  
		  out.println("}"); 
		  
		  out.println("body{");
			 out.println("background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrs34xvaStnc4SgRtApI-DRdFKeA6UW3WtxurZC3mobNlvBVei84iJyOWlUv-TAGDfeag&usqp=CAU')");
			  out.println("background-repeat: no-repeat;");
			  out.println("background-size: 1500px 1200px;");
			  out.println("}"); 
			 
		  
		  out.println("</style>");  
		  out.println("</head>");
		
		  out.println("<body>");
		  
		LOGGER.info("Calling getAllHotels method from SelectHotelDetails dao layer");
		List<AdminHotelsPojo> list=SelectHotelDetails.getAllHotels();
		
		
		LOGGER.info("Recieved hotel list in the form of arrayList and showing it to users");
		
		out.println("<h1><center>Choose Hotels</center></h1>");
		out.println("<center>");
		out.print("<table>");
		out.println("<tr><th>HotelID</th><th>HotelName</th><th>HotelType</th><th>TotalRooms</th><th>AvailableRooms</th></tr>");
		for(AdminHotelsPojo h:list) {
			int HotelID = h.getHotelID();
			HttpSession session = request.getSession();
			session.setAttribute("HotelID", HotelID);
			System.out.println(HotelID);
			out.print("<tr><td>"+h.getHotelID()+"</td> <td>"+h.getHotelName()+"</td>  <td>"+h.getHotelType()+"</td> <td>"+h.getTotalRooms()+"</td>   <td>"+h.getAvailableRooms()+"</td>     <td><a href='RoomBooking.html' style='color:orangered;'>Book</a></td></tr>");
		}
		out.print("</table>");
		out.println("</center");
		out.println("</body>");
		out.print("</html>");
		out.print("</head>");
		
		
				
		out.close();
	}

}
