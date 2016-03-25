package dbconnection;

import java.sql.*;

public interface ConnectionIntr {
	public boolean connect(String user, String pass);
	public boolean getIsConnected();
	public ResultSet query(String query);
}
