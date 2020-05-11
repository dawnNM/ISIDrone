package entities;

public class Order extends Cart{
	private static final long serialVersionUID = 1L;
	
	int id;
	int userId;
	String date;
		
	public Order(int id, int userId, String date) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
	}

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
