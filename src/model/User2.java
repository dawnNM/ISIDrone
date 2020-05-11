package model;

public class User2 {
	
	int id;
	String lastName;
	String firstName;
	String email;
	String password;
	int shipAddressId;
	userType usertype;
	
	public User2() {
		super();
	}

	public User2(int id, String lastName, String firstName, String email, String password, int shipAddressId,
			userType usertype) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.shipAddressId = shipAddressId;
		this.usertype = usertype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getShipAddressId() {
		return shipAddressId;
	}

	public void setShipAddressId(int shipAddressId) {
		this.shipAddressId = shipAddressId;
	}

	public userType getUsertype() {
		return usertype;
	}

	public void setUsertype(userType usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "User2 [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", password=" + password + ", shipAddressId=" + shipAddressId + ", usertype=" + usertype + "]";
	}

	
	
}
