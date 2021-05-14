package model;

public class BookingHotelPojo {
	private int bookingId;
	private String custName;
	private String custAge;
	private long custMobNo;
	private String Date;
	private String roomQuant;
	private int Userid;
	private int HotelID;
	private AdminHotelsPojo h;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAge() {
		return custAge;
	}
	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}
	public Long getCustMobNo() {
		return custMobNo;
	}
	public void setCustMobNo(long custMobNo) {
		this.custMobNo = custMobNo;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getRoomQuant() {
		return roomQuant;
	}
	public void setRoomQuant(String roomQuant) {
		this.roomQuant = roomQuant;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public int getHotelID() {
		return HotelID;
	}
	public void setHotelID(int hotelID) {
		HotelID = hotelID;
	}
	public AdminHotelsPojo getH() {
		return h;
	}
	public void setH(AdminHotelsPojo h) {
		this.h = h;
	}
	
}
