package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.User;
import service.UserServiceImpl;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	
	

	private static final long serialVersionUID = 1L;
	
	static final Logger LOGGER=Logger.getLogger(Signup.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		LOGGER.info("Inside dopost method of Signup servlet");
		UserServiceImpl usi1 = new UserServiceImpl();
		User u1 = new User();
		
		LOGGER.info("Getting user details from signup page");
		String Name = request.getParameter("Name");
		long PhoneNumber = Long.parseLong(request.getParameter("PhoneNumber"));
		String EmailID = request.getParameter("EmailID");
		String Password = request.getParameter("Password");
		
		LOGGER.info("Setting user details in pojo class");
		u1.setName(Name);
		u1.setPhoneNumber(PhoneNumber);
		u1.setEmailID(EmailID);
		u1.setPassword(Password);
		
		
		int x = 0;
		try {
			LOGGER.info("This method goes to UserServiceImpl in service layer");
			x = usi1.signup(u1);
		}
		catch (Exception e)
		{
			LOGGER.error("Exceptions is raised");
			e.printStackTrace();
		}
		if(x>0)
		{
			LOGGER.info("Redirecting to the login page");
			response.sendRedirect( "login.html" );
		}
	}

}
