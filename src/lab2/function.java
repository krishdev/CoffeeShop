package lab2;

import java.util.Date;

public class function {

	private String fname;
	private Date date;
	private String lname;
	private String password;
	private String email;
	private String street1;
	private String street2;
	private String city;
	private String zipcode;
	private String state;
	private String telephone;
	
	
	
	public function(String fname, String lname, String password, String email, String street1, String street2, String city, String zipcode, String state, String telephone){
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.telephone = telephone;
		this.date = new Date();
			
		
	}
	
	public String getfName() {
		return fname;
	}
	public Date getDate() {
		return date;
	}
	public String getlname() {
		return lname;
	}
	public String getpassword() {
		return password;
	}
	public String getemail() {
		return email;
	}
	public String getstreet1() {
		return street1;
	}
	public String getstreet2() {
		return street2;
	}
	public String getcity() {
		return city;
	}
	public String getzipcode() {
		return zipcode;
	}
	public String getstate() {
		return state;
	}
	public String gettelephone() {
		return telephone;
	}
	//public void calculate(String uname, String upass){
	//this.uname = uname;
	//this.upass = upass;
	
	//if(uname==fname && upass==password){
		
		//}
	//}
	
	
}
