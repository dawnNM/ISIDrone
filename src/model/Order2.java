package model;

import java.util.Date;

public class Order2 {
	
	int id;
	int product_id;
	int qty;
	int user_id;
	String firstName;
	String lastName;
	Date date;
	boolean isShipped;
	
	public Order2() {
	}
	
	public Order2(int id, int product_id, int qty, int user_id, String firstName, String lastName, Date date,
			boolean isShipped) {
		this.id = id;
		this.product_id = product_id;
		this.qty = qty;
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.isShipped = isShipped;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isShipped() {
		return isShipped;
	}
	public void setShipped(boolean isShipped) {
		this.isShipped = isShipped;
	}
	@Override
	public String toString() {
		return "Order2 [id=" + id + ", product_id=" + product_id + ", qty=" + qty + ", user_id=" + user_id
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", date=" + date + ", isShipped=" + isShipped
				+ "]";
	}
	
}
