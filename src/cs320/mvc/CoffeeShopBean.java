package cs320.mvc;

public class CoffeeShopBean {

	private String SName;
	private String SStreet1;
	private String SStreet2;
	private String SStreet3;
	private String STelephone;
	private String SLatitude;
	private String SLongitude;
	private String SCity;
	private String SZipcode;
	public String getSCity() {
		return SCity;
	}
	public void setSCity(String sCity) {
		SCity = sCity;
	}
	public String getSZipcode() {
		return SZipcode;
	}
	public void setSZipcode(String sZipcode) {
		SZipcode = sZipcode;
	}
	public String getSLatitude() {
		return SLatitude;
	}
	public void setSLatitude(String sLatitude) {
		SLatitude = sLatitude;
	}
	public String getSLongitude() {
		return SLongitude;
	}
	public void setSLongitude(String sLongitude) {
		SLongitude = sLongitude;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		this.SName = sName;
	}
	public String getSStreet1() {
		return SStreet1;
	}
	public void setSStreet1(String sStreet1) {
		this.SStreet1 = sStreet1;
	}
	public String getSStreet2() {
		return SStreet2;
	}
	public void setSStreet2(String sStreet2) {
		this.SStreet2 = sStreet2;
	}
	public String getSStreet3() {
		return SStreet3;
	}
	public void setSStreet3(String sStreet3) {
		this.SStreet3 = sStreet3;
	}
	public String getSTelephone() {
		return STelephone;
	}
	public void setSTelephone(String sTelephone) {
		this.STelephone = sTelephone;
	}
}
