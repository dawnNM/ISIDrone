package entities;

public class Category {
	private int id,order;
	private String name,
		description;
	private boolean isActive;
	
	public Category() {}
	
	public Category(int id, String name, String description,int order,boolean isActive) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.order=order;
		this.isActive=isActive;
	}

	public int getId() {
		return id;
	}

	public boolean getisActive()
	{
		return isActive;
	}
	
	public int getorder() {
		return order;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setorder(int order) {
		this.order = order;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setisActive(boolean isActive) {
		this.isActive=isActive;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
