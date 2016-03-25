package employee;

public abstract class Staff {
	protected int id;
	protected String name;
	protected String phone; 
	
	public Staff(int id, String name, String phone){
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return this.phone;
	}
}
