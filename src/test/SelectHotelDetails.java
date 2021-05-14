package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AdminHotelsDaoImpl;
import dbutililty.DbConnection;
import model.AdminHotelsPojo;

public class SelectHotelDetails {
	
	private SelectHotelDetails shd=new SelectHotelDetails();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbConnection.getCon();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbConnection.conClose();
	}

	@Test
	
	public void getHotelsByIdTest(){
		
		AdminHotelsPojo h1 = new AdminHotelsPojo();
		h1 = shd.getHotelsById(3);
		boolean actual=false;
		if(!h1.getHotelName().contentEquals(null)) {
			actual=true;
		}
		boolean expected=true;
		assertEquals(expected,actual);
	
		
	
	
}
	
	

	private AdminHotelsPojo getHotelsById(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
