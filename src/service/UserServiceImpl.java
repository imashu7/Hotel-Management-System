package service;

import org.apache.log4j.Logger;

import dao.UserDaoImpl;
import model.User;
import servlet.Login;

public class UserServiceImpl implements UserService
{
	static final Logger LOGGER=Logger.getLogger(Login.class);
	private UserDaoImpl udi = new UserDaoImpl();
	public int signup(User u1) throws Exception
	{
		LOGGER.info("This signup method goes to UserDaoImpl and recieving x value ");
		int x = udi.signup(u1);
			
		return x;
	}

	public int[] login(User u1) throws Exception
	{
		LOGGER.info("This login method goes to UserDaoImpl and recieving flag value ");
		int[] flag = udi.login(u1);
		return flag;
	}

}
