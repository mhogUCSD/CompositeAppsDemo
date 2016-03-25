package dbconnection;

import java.sql.*;

public abstract class Connection {
	
	protected ConnectionIntr con;
	
	public Connection(ConnectionIntr c){
		this.con = c;
	}
	
	public void setConnectionType(ConnectionIntr c){
		this.con = c;
	}
	public abstract boolean connect(String user, String pass);
	public abstract boolean getIsConnected();
	public abstract ResultSet query(String query);
}
