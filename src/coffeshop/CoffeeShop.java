package coffeshop;

public class CoffeeShop {


	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private double lat;
	private double lon;
	
	public CoffeeShop(String name, String address, String city, String state,
			String zip, String phone, double lat, double lon) {
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.lat = lat;
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}
	
	
	
	
}
