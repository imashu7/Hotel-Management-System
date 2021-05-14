package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserDaoImpl;
import dbutililty.DbConnection;
import model.User;

public class UserDaoImplTest {
	
	private UserDaoImpl adi=new UserDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbConnection.getCon();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbConnection.conClose();
	}

	@Test
	
	public void signupTest() throws Exception {
		User u1 = new User();
		u1.setName("Rohit");
		u1.setPhoneNumber(9876543);
		u1.setEmailID("rohit@gmail.com");
		u1.setPassword("rohit@123");
		
		int result = adi.signup(u1);
		int expected = 1;
		assertEquals(result,expected);
	}
	

}
