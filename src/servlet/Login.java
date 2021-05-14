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

import model.User;
import service.UserServiceImpl;


@WebServlet("/Login")
public class Login extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	static final Logger LOGGER=Logger.getLogger(Login.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside dopost method of login servlet");
		UserServiceImpl usi1 = new UserServiceImpl();
		User u1 = new User();
		
		
		String Name = request.getParameter("Username");
		String Password = request.getParameter("Password");
//		System.out.println(Name);
//		System.out.println(Password);
		
		u1.setName(Name);
		u1.setPassword(Password);
		int[] flag = {0,0};
		try {
			LOGGER.info("This method goes to UserServiceImpl in service layer ");
			flag = usi1.login(u1);
		}
		catch (Exception e)
		{
			LOGGER.error("Exceptions is raised");
			e.printStackTrace();
		}
		
		if(flag[0]==1)
		{
			HttpSession session = request.getSession();
			session.setAttribute("uID", flag[1]);
			if(flag[1] == 1)
			{
				LOGGER.info("Going to admin home page");
				response.sendRedirect("adminHome.jsp");
				PrintWriter out = response.getWriter();
				out.print("Login successfully.");
			}
			else
			{
				LOGGER.info("Going to user home page");
				response.sendRedirect("home.html");
				PrintWriter out = response.getWriter();
				out.print("Login successfully.");
			}
		}
		else
		{
			LOGGER.info("Data didn't matched to the database");
			response.sendRedirect("login.html");
			PrintWriter out = response.getWriter();
			out.print("Wrong Entry,please Sign up first.");
		}
	}

}
