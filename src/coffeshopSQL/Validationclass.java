package coffeshopSQL;

public class Validationclass {
	private String name;
	private String password;
	private String email;
	private String zipcode;
	
	
	

	public Validationclass(String name,String password,String email,String zipcode) {
		this.name=name;
		this.password=password;
		this.email=email;
		this.zipcode=zipcode;
		// TODO Auto-generated constructor stub
	}

	public Validationclass() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
