import java.util.HashMap;

import dbconnection.*;
import employee.Employee;
import employee.EmployeeFactory;

public class Main {

	public static void main(String[] args) {
		Connection con = new DBConnection(new JDBCConnection());
		EmployeeFactory ef = new EmployeeFactory();
		HashMap<Integer, Employee> hash = null;
		
		
		if(con.connect("root", "H0g3!v3dT")){
			hash = ef.employeeRsToHash(con.query("SELECT * FROM employees"));
		}
	}
}
