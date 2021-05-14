package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.SelectBookingDetails;
import dao.SelectHotelDetails;
import model.BookingHotelPojo;


@WebServlet("/ShowBookings")
public class ShowBookings extends HttpServlet {
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("Inside dopost method of login servlet");
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
		
		
		LOGGER.info("calling getAllBookings method from SelectBookingDetails Dao layer");
		List<BookingHotelPojo> list=SelectBookingDetails.getAllBookings();
		
		LOGGER.info("Recieved Booking lists in the form of arrayList and showing it ");
		out.println("<center>");
		out.print("<table>");
		out.println("<h1><center>Booking Lists</center></h1>");
		out.print("<table>");
		out.println("<tr><th>BookingID</th><th>HotelID</th><th>UserID</th><th>CustomerName</th><th>CustomerAge</th><th>CustomerMobNo</th><th>DateOfBooking</th><th>TotalRooms</th></tr>");
		for(BookingHotelPojo b1:list) {
			out.print("<tr><td>"+b1.getBookingId()+"</td> <td>"+b1.getHotelID()+"</td>  <td>"+b1.getUserid()+"</td> <td>"+b1.getCustName()+"</td>   <td>"+b1.getCustAge()+"</td>  <td>"+b1.getCustMobNo()+"</td>  <td>"+ b1.getDate()+"</td>  <td>"+b1.getRoomQuant()+"</td> </tr>");
		}
		out.print("</table>");
		out.println("</center>");
		out.println("</body>");
		out.print("</html>");
		out.print("</head>");
		
		
			
		out.close();
	}

	

}
