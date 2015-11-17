package coffeshop;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CoffeeUser {
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;
	private String zipcode;
	
	public CoffeeUser(String first, String last, String zip, String username, String password){
		
		this.username = username;
		this.password = getHash(password);
		
		this.firstName = first;
		this.lastName = last;
		this.zipcode = zip;
		
		System.out.println(this.firstName + "'s Password (SHA-256):" + this.password+"username is:"+this.getUsername());
	}

	private String getHash(String text){
		
		try {			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes("UTF-8"));
			byte[] digest = md.digest();
			
			
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
		        sb.append(String.format("%02X", b));
		    }
			return sb.toString();			
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();		
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		
		return "";
	}
	
	public boolean isUser(String username, String password){		
		return this.username.toLowerCase().equals(username) && getHash(password).equals(this.password);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getZipcode() {
		return zipcode;
	}	
}
