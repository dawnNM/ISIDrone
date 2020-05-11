package model;

public class OrderWithUName {
	private static final long serialVersionUID = 1L;
	
	int id;
	int userId;
	String userName;
	String date;
	Boolean isShipped;
	
	public OrderWithUName(int id, int userId, String userName, String date, Boolean isShipped) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.date = date;
		this.isShipped = isShipped;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Boolean getIsShipped() {
		return isShipped;
	}
	public void setIsShipped(Boolean isShipped) {
		this.isShipped = isShipped;
	}

	@Override
	public String toString() {
		return "OrderWithUName [id=" + id + ", userId=" + userId + ", userName=" + userName + ", date=" + date + "]";
	}
	
	
}
