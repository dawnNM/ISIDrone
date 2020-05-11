package manager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import util.Const;

public class MDB {
	private static Connection connection = null;
	
	public static void connect() throws SQLException {
		
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		
		 createAndReadFromFile();
		 createConfigFile();
		 readConfigFile();
		 
		 String password = readPasswordFromConfigFile();
		 System.out.println(password);
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String mysqlURL="jdbc:mysql://127.0.0.1:3306/isidrone?serverTimezone=UTC";
			connection = DriverManager.getConnection(mysqlURL, "root", "abc123...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet execQuery(String query) {
		PreparedStatement ps = getPS(query);
		ResultSet rs = null;
		try {
			if(ps != null) {
				ps.execute();
				rs = ps.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rs;
	}
	
	public static PreparedStatement getPS(String query) {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
			ps = connection.prepareStatement(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static PreparedStatement getPS(String query, int id) {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
			if (id == 1)
				ps = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static PreparedStatement getPS(String query, String column) {
		return getPS(query, new String[]{column});
	}
	
	public static PreparedStatement getPS(String query, String[] columns) {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
				ps = connection.prepareStatement(query,columns);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static void disconnect() {
		try {
			if(connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection = null;
		}
	}
	
	public static void createAndReadFromFile() {
		
		try 
		{
			File f = new File("demo2.txt");
			FileOutputStream fos;
			fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF("Demo11212 Content");
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			String str = dis.readUTF();
			System.out.println(str);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createConfigFile() 
	{
		try 
		{	
			Properties p = new Properties();
			OutputStream os;
		
			//os = new FileOutputStream(Const.PATH_CONFIG_PROPERTY+"Config.properties");
			os = new FileOutputStream("Config.properties");

			p.setProperty("usernm", "root");
			p.setProperty("passwd", "admin");
			
			System.out.println("Data Saved in properties file");

			p.store(os, null);
		}
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				

	}

	public static void readConfigFile() 
	{
		try 
		{	
			Properties p = new Properties();
			InputStream is = new FileInputStream("Config.properties");
			p.load(is);
			
			System.out.println(p.getProperty("usernm"));
			System.out.println(p.getProperty("passwd"));
		}
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				

	}
	
	public static String readPasswordFromConfigFile() 
	{
		String password="abc";
		try 
		{	
			Properties p = new Properties();
			InputStream is = new FileInputStream("Config.properties");
			p.load(is);			
			password = p.getProperty("passwd");
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		return password;
	}
	
	public static String readUsernameFromConfigFile() 
	{
		String username="abc";
		try 
		{	
			Properties p = new Properties();
			InputStream is = new FileInputStream("Config.properties");
			p.load(is);
			username = p.getProperty("usernm");
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}				
		return username;
	}
}
