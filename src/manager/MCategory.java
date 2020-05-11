package manager;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;
import util.Hash;

public class MCategory {

	public static ArrayList<Category> getCategories(){
		ArrayList<Category> categories = new ArrayList<Category>();

		try {
			MDB.connect();
			String query = "SELECT * FROM category";
			ResultSet rs = MDB.execQuery(query);
			while(rs.next()) {
				categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getBoolean(5)));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();	
		}
		
		return categories;
	}
	public static int isExistcategory(int order) {
		System.out.println(order);
		int isExist = -1;		
		try {
			MDB.connect();
			String query = "SELECT * FROM category where `order` = ?";
			PreparedStatement ps = MDB.getPS(query);
			
			ps.setInt(1, order);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			isExist=1;
			while(rs.next())
			{
				isExist=0;
			}
			//isExist = (rs.first() ? 0 : 1);
		} catch (SQLException e) {
			isExist = -1;
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();	
		}
		
		return isExist;
	}
	
	public static int isExist(int category) {
		int isExist = -1;		
		try {
			MDB.connect();
			String query = "SELECT 'exist' FROM category WHERE id = ?";
			PreparedStatement ps = MDB.getPS(query);
			
			ps.setInt(1, category);
			ResultSet rs = ps.executeQuery();
			
			isExist = (rs.first() ? 0 : 1);
		} catch (SQLException e) {
			isExist = -1;
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();	
		}
		
		return isExist;
	}
	public static int addnewCategory(Category c)
	{
		int r=-1;
		try {
			MDB.connect();
			
			
			String query = "INSERT INTO category (`name`, `description`, `order`, `isActive`) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = MDB.getPS(query);
		
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setInt(3, c.getorder());
			ps.setBoolean(4,c.getisActive());
			 r=ps.executeUpdate();
			
		} catch (Exception  e) {
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();	
		}
		return r;
	}
}
