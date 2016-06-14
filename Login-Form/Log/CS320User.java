package Homework2;

public class CS320User {

	
	private String first;
	private String last;
	private String email;
	private String password;
	
	public CS320User(String first,String last,String email,String password) {
		super();
		
		this.first = first;
		this.last =last ;
		this.email = email;
		this.password = password;
		
	
}

	

	public String getfirst() {
		return first;
	}

	

	public String getlast() {
		return last;
	}

	

	public String getemail() {
		return email;
	}



	public String getpassword() {
		return password;
	}

	
}