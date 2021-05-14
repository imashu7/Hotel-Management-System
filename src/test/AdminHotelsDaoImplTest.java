package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AdminHotelsDaoImpl;
import dbutililty.DbConnection;
import model.AdminHotelsPojo;

public class AdminHotelsDaoImplTest {
 private AdminHotelsDaoImpl adi=new AdminHotelsDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbConnection.getCon();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbConnection.conClose();
	}

	@Test

	public void saveTest() {
		AdminHotelsPojo h1 = new AdminHotelsPojo();
		h1.setHotelName("holly");
		h1.setHotelType("2 star");
		h1.setTotalRooms("200");
		h1.setAvailableRooms("120");
		
		int result = adi.save(h1);
		int expected = 1;
		assertNotEquals(result,expected);
		
		
	}

}
