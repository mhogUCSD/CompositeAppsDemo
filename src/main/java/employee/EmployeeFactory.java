package employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class EmployeeFactory {
	
	public HashMap<Integer, Employee>  employeeRsToHash(ResultSet rs){
		HashMap<Integer, Employee> hash = new HashMap<Integer, Employee>();
		Employee emp = null;
		
		if(!rs.equals(null)){
			try {
				while(rs.next()){
					Integer id = rs.getInt("employee_id");
					String name = rs.getString("name");
					String number = rs.getString("phone_number");
					String supervisor = rs.getString("supervisor");
					
					emp = new Employee(id, name, number, supervisor);
							
					hash.put(id, emp);
				}
			} catch (SQLException e) {
				System.err.println("Error in EmployeeFactory");
				e.printStackTrace();
			}
		}
		return hash;
	}
}
