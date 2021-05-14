package test;


import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DeleteHotelsDao;
import dbutililty.DbConnection;
import model.AdminHotelsPojo;

public class DeleteHotelsDaoTest {
 private DeleteHotelsDao dhd=new DeleteHotelsDao();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbConnection.getCon();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbConnection.conClose();
	}
	
	@Test
	
	public void deleteTest() {
		int id=16;
		int result = dhd.delete(id);
		int expected=1;
		assertEquals(result,expected);
		
	}
	
}
