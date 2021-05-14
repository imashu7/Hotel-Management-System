package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("/DeleteHotels")
public class DeleteHotels extends HttpServlet {
	static final Logger LOGGER=Logger.getLogger(Login.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Inside dopost method of login servlet");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		LOGGER.info("Calling delete method from DeleteHotelsDao in dao layer");
		dao.DeleteHotelsDao.delete(id);
		LOGGER.info("Showing hotel details");

		response.sendRedirect("ShowHotels");
	}

	
}
