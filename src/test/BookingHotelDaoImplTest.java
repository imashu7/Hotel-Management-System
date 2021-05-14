package test;

import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.BookingHotelDaoImpl;
import dbutililty.DbConnection;
import model.BookingHotelPojo;

public class BookingHotelDaoImplTest {
	
	private BookingHotelDaoImpl bhd=new BookingHotelDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbConnection.getCon();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbConnection.conClose();
	}

	@Test
	
	public void booking() throws Exception {
		BookingHotelPojo b1=new BookingHotelPojo();
		b1.setHotelID(34);
		b1.setUserid(23);
		b1.setCustName("ronit");
		b1.setCustAge("12");
		b1.setCustMobNo(98799874);
		b1.setDate("12-09-2021");
		b1.setRoomQuant("9");
		
		
		int result = bhd.booking(b1);
		int expected = 1;
		assertNotEquals(result,expected);
	}

}