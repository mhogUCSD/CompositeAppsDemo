package dbconnection;

import java.sql.*;

public class DBConnection extends Connection {

	public DBConnection(ConnectionIntr c){
		super(c);
	}
	
	public boolean getIsConnected(){
		return con.getIsConnected();
	}
	
	public boolean connect(String user, String pass){
		return con.connect(user, pass);
	}
	
	@Override
	public ResultSet query(String query) {
		return super.con.query(query);
	}

}
