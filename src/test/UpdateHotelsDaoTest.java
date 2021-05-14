package test;



import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UpdateHotelsDao;
import dbutililty.DbConnection;
import model.AdminHotelsPojo;

public class UpdateHotelsDaoTest {
 private UpdateHotelsDao adi=new UpdateHotelsDao();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbConnection.getCon();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbConnection.conClose();
	}

	@Test
	
	public void updateTest() {
		AdminHotelsPojo h1 = new AdminHotelsPojo();
		h1.setHotelID(16);
		h1.setHotelName("holly");
		h1.setHotelType("2 star");
		h1.setTotalRooms("200");
		h1.setAvailableRooms("120");
		
		int result = adi.update(h1);
		int expected = 1;
		assertEquals(result,expected);
		
	}
}