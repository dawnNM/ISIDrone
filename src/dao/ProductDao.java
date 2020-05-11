package dao;
import java.sql.*;
import java.util.ArrayList;

import model.Product;
import model.User2;
import model.Order2;
import model.OrderWithUName;
import entities.Order;
import entities.User;
import manager.MDB;
import model.userType;

public class ProductDao 
{
	String password = "abc123...";

	public Product getProduct(int pid) 
	{
		Product p = new Product();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from product where id="+pid);
			if(rs.next())
			{
				p.setId(rs.getInt("id"));
				p.setCategory(rs.getInt("category"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getFloat("price"));
				p.setSerialNumber(rs.getString("serialNumber"));
				p.setImgName(rs.getString("imgName"));
				p.setStockQty(rs.getInt("stockQty"));
				p.setActive(rs.getBoolean("isActive"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return p;
	}
	
	public ArrayList<Product> getAllProducts() 
	{
		ArrayList<Product> productList = new ArrayList<>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from product");
			while(rs.next())
			{
				
				Product product = new Product(rs.getInt("id"),rs.getInt("category"),rs.getString("name"),rs.getString("description"),rs.getFloat("price"),rs.getString("serialNumber"),rs.getString("imgName"),rs.getInt("stockQty"),rs.getBoolean("isActive"));
				productList.add(product);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return productList;
	}
	
	public int addProduct(int pcategory, String pname, String pdescription, Float pprice, String SerialNumber, String ImgName, int stockQty, boolean isActive) 
	{
//		System.out.println("--------------");
//		System.out.println(pcategory);
//		System.out.println(pname);
//		System.out.println(pdescription);
//		System.out.println(pprice);
//		System.out.println(SerialNumber);
//		System.out.println(ImgName);
//		System.out.println(stockQty);
//		System.out.println(isActive);
//		System.out.println("--------------");
		int rvalue = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			int rv = st.executeUpdate("INSERT INTO product (category, name, description, price, serialNumber, imgName, stockQty, isActive)" + 
					"VALUES ("+ pcategory +", '"+ pname+"', '"+pdescription+"', "+ pprice+", '"+ SerialNumber + "','" + ImgName + "',"+ stockQty +"," + isActive + ")");
			if (rv > 0) {
	            System.out.println("success");
	            rvalue = 1;
	        } else {
	            System.out.println("stuck somewhere");
	            rvalue = -1;
	        }
			
			rvalue = rv;
			//System.out.println("Rv : " + rv);
			//System.out.println("Row Inserted Successfully");			
		}catch(Exception e) {
			System.out.println(e);
		}
		return rvalue;
	}
	
	public int deleteProduct(int pid) 
	{
		int rvalue = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			int rv = st.executeUpdate("delete from product where id="+pid);
			if (rv > 0) {
	            System.out.println("success");
	            rvalue = 1;
	        } else {
	            System.out.println("stuck somewhere");
	            rvalue = -1;
	        }
			
			rvalue = rv;
		}catch(Exception e) {
			System.out.println(e);
		}
		return rvalue;
	}
	
	
	public ArrayList<OrderWithUName> getAllOrders() 
	{
		ArrayList<OrderWithUName> orderListWithName = new ArrayList<>();
		try
		{
			MDB.connect();
			String query;
			PreparedStatement ps;
			ResultSet rs;
			query = "select isidrone.order.id, isidrone.order.user_id, isidrone.order.date, isidrone.order.isShipped, isidrone.user.firstName from isidrone.order join isidrone.user on isidrone.order.user_id = isidrone.user.id;";
			ps = MDB.getPS(query);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("\n"+rs.getString("date"));
				OrderWithUName orderwithuname = new OrderWithUName(rs.getInt(1),rs.getInt(2),rs.getString(5),rs.getString(3),rs.getBoolean(4));
				orderListWithName.add(orderwithuname);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
		MDB.disconnect();	
		}
		return orderListWithName;
	}
	
	/*
	 * public String getUserName(int uid) { String uname = "Abc"; try {
	 * Class.forName("com.mysql.jdbc.Driver"); Connection con =
	 * DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
	 * Statement st = con.createStatement(); ResultSet rs =
	 * st.executeQuery("SELECT 'firstName' FROM isidrone.user where id = "+uid);
	 * while(rs.next()) {
	 * 
	 * uname = rs.getString("firstName"); } }catch(Exception e) {
	 * System.out.println(e); } return uname;
	 * 
	 * }
	 */
	
	public int deleteOrder(int oid) 
	{
		int rvalue = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			int rv = st.executeUpdate("delete from isidrone.order where id="+oid);
			if (rv > 0) {
	            System.out.println("success");
	            rvalue = 1;
	        } else {
	            System.out.println("stuck somewhere");
	            rvalue = -1;
	        }
			
			rvalue = rv;
		}catch(Exception e) {
			System.out.println(e);
		}
		return rvalue;
	}
	
	public int modifyProduct(int pid, int pcategory, String pname, String pdescription, Float pprice, String SerialNumber, String ImgName, int stockQty, boolean isActive) 
	{
		System.out.println(isActive);
		int isActiveInt = isActive ? 1 : 0;
		
		int rvalue = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			
			int rv = st.executeUpdate("UPDATE product SET category = '" + pcategory + "', name = '" + pname + "', description = '" + pdescription + "', price = '" + pprice + "', serialNumber = '" + SerialNumber + "', imgName = '" + ImgName + "', stockQty = '" + stockQty + "', isActive = '" + isActiveInt + "' WHERE id = " + pid);
					
			if (rv > 0) {
	            System.out.println("success");
	            rvalue = 1;
	        } else {
	            System.out.println("stuck somewhere");
	            rvalue = -1;
	        }
			
			rvalue = rv;
			//System.out.println("Rv : " + rv);
			//System.out.println("Row Inserted Successfully");			
		}catch(Exception e) {
			System.out.println(e);
		}
		return rvalue;
	}
	
	public int changeOrderShipping(int oid, boolean isShipped) 
	{
		// System.out.println("Changing Shipping Status : " + oid);
		// int isActiveInt = isActive ? 1 : 0;
		
		if(isShipped==true)
			isShipped=false;
		else
			isShipped=true;
		
		
		int isShippedInt = isShipped ? 1 : 0;

		
		int rvalue = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isidrone?serverTimezone=UTC","root", password);
			Statement st = con.createStatement();
			
			int rv = st.executeUpdate("UPDATE isidrone.order SET isShipped = '" + isShippedInt + "' WHERE id = " + oid);
					
			if (rv > 0) {
	            System.out.println("success");
	            rvalue = 1;
	        } else {
	            System.out.println("stuck somewhere");
	            rvalue = -1;
	        }
			
			rvalue = rv;
			//System.out.println("Rv : " + rv);
			//System.out.println("Row Inserted Successfully");			
		}catch(Exception e) {
			System.out.println(e);
		}
		return rvalue;
	}
	
	public ArrayList<Order2> getAllOrders2() 
	{
		ArrayList<Order2> orderList2 = new ArrayList<>();
		try
		{
			MDB.connect();
			String query;
			PreparedStatement ps;
			ResultSet rs;
			query = "select order.id, order_info.product_id, order_info.qty ,order.user_id, user.firstName, user.lastName ,order.date, order.isShipped " 
					+ "from isidrone.user join isidrone.order " 
					+ "on order.user_id = user.id " 
					+ "join isidrone.order_info " 
					+ "on order.id = order_info.order_id;";
			ps = MDB.getPS(query);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Order2 order2 = new Order2(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getBoolean(8));
				orderList2.add(order2);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
		MDB.disconnect();	
		}
		return orderList2;
	}
	
	public ArrayList<User2> getAllCustomers() 
	{	
		ArrayList<User2> userList = new ArrayList<>();
		try
		{
			MDB.connect();
			String query;
			PreparedStatement ps;
			ResultSet rs;
			query = "SELECT id, lastName, firstName, email, password, ship_address_id, usertype FROM isidrone.user;";
			ps = MDB.getPS(query);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				User2 user2 = new User2(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),userType.valueOf(rs.getString(7)));
				userList.add(user2);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
		MDB.disconnect();	
		}
		return userList;
	}
	
}