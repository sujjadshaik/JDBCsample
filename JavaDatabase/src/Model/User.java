package Model;

public class User {
	private int id;
	private String username;
	private String role;
	private String contactNumber;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String role, String contactNumber, String password) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.contactNumber = contactNumber;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	

}
