package cs320.mvc;

public class ModelCoffeeSearch {
	
	
	private String Name;
	private String Phone;
	private String City;
	private String Zipcode;
	private String Id;
	private String Address;
	

	private String Lati;
	private String Longi;
	
	public ModelCoffeeSearch(String Id, String Name, String Phone, String City, String Lati, String Longi,String Zipcode) {
		super();
		
		this.Id=Id;
		this.Name=Name;
		this.City=City;
		this.Phone=Phone;
		this.Lati=Lati;
		this.Longi=Longi;
		this.Zipcode=Zipcode;
		
		// TODO Auto-generated constructor stub
	}
	
	public String getId(){
		return Id;
	}
	public String getLati() {
		return Lati;
	}
	public String getLongi() {
		return Longi;
	}
	public String getName() {
		return Name;
	}
	
	public String getAddress() {
		return Address;
	}

	public String getPhone() {
		return Phone;
	}
	
	public String getCity() {
		return City;
	}
	
	public String getZipcode() {
		return Zipcode;
	}
	
	
	
}
