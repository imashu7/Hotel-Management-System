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

import dao.SelectHotelDetails;
import model.AdminHotelsPojo;


@WebServlet("/ShowHotels")
public class ShowHotels extends HttpServlet {
	
	static final Logger LOGGER=Logger.getLogger(ShowHotels.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Inside doGet method of ShowHotels servlet");
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
			 out.println("background-image: url('http://www.welkinholidaysinnsuites.com/assets/new/images/awesome-slider/as8.jpg')");
			  out.println("background-repeat: no-repeat;");
			  out.println("background-size: 1500px 1200px;");
			  out.println("}"); 
			 
		  
		  out.println("</style>");  
		  out.println("</head>");
		
		  out.println("<body>");
		  
		
		
		LOGGER.info("calling getAllHotels method from SelectHotelDetails Dao layer");
		List<AdminHotelsPojo> list=SelectHotelDetails.getAllHotels();
		
		LOGGER.info("Recieved hotel list in the form of arrayList and showing it to Admin ");
		out.println("<center>");
		out.print("<table>");
		
		out.println("<h1><center>Hotel Lists</center></h1>");
		out.print("<table>");
		out.println("<tr><th>HotelID</th><th>HotelName</th><th>HotelType</th><th>TotalRooms</th><th>AvailableRooms</th></tr>");
		for(AdminHotelsPojo h:list) {
			out.print("<tr><td>"+h.getHotelID()+"</td> <td>"+h.getHotelName()+"</td>  <td>"+h.getHotelType()+"</td> <td>"+h.getTotalRooms()+"</td>   <td>"+h.getAvailableRooms()+"</td>  <td><a href='UpdateHotels?id="+h.getHotelID()+"' style='color:orangered;'>Update</a></td> <td><a href='DeleteHotels?id="+h.getHotelID()+"' style='color:orangered;'>Delete</a></td></tr>");
		}
		
		
		out.print("</table>");
		out.println("<a href='hotels.html' style='color:blue;'><h3>Add New Hotel<h3></a>");
		out.println("</center");
		
		out.println("</body>");
		out.print("</html>");
		out.print("</head>");
		
		
			
		out.close();
	}

}
