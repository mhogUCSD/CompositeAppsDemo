package employee;

public class Employee extends Staff {
	private String supervisor;
	
	public Employee(int id, String name, String phone, String supervisor) {
		super(id, name, phone);
		this.supervisor = supervisor;
	}

	public String getSupervisor(){
		return this.supervisor;
	}
	
	public void setSupervisor(String s){
		this.supervisor = s;
	}
}
