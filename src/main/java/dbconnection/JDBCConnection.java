package dbconnection;

import java.sql.*;

public class JDBCConnection implements ConnectionIntr {

	private java.sql.Connection con;
	private Statement st;
	
	// designates if there was a successful connection to the database or not
	private boolean isConnected;
	
	private String driver = "com.mysql.jdbc.Driver";
	
	private String database = "compapps";
	private String databaseURL = "jdbc:mysql://localhost:3306/" + database;
	

	public JDBCConnection(){
		isConnected = false;
	}
	
	public boolean getIsConnected(){
		return this.isConnected;
	}
	
	public void setIsConnected(boolean c){
		this.isConnected = c;
	}
	
	public boolean connect(String user, String pass){
		// connect JDBC driver
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			System.err.println("Error: unable to load driver class!");
			e.printStackTrace();
			this.isConnected = false;
			return false;
		}
		
		// attempt to login to the DB
		try {
			con = DriverManager.getConnection(databaseURL, user, pass);
		} catch (SQLException e) {
			System.err.println("Unable to connect to " + e);
			//e.printStackTrace();
			this.isConnected = false;
			return false;
		}
		
		// create a DB statement to parse from
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Unable to create statement: " + e);
		//	e.printStackTrace();
			this.isConnected = false;
			return false;
		}
		
		this.isConnected = true;
		
		return true;
	}

	// queries the serve. If a result is found, return it. Else return null.
	public ResultSet query(String query) {
		ResultSet rs = null;
		try {
			if(!st.equals(null)){
				rs = st.executeQuery(query);
				return rs;
			}
		} catch (SQLException e) {
			System.err.println("Unable to recover data.");
			e.printStackTrace();
		}
		return null;
	}

}
