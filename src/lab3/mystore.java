package lab3;

import java.util.Date;

public class mystore {
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
	private String suffix;
	private String prefix;
	private String areacode;
	
	
	
	public mystore(String fname, String lname, String password, String email, String street1, String street2, String city, String zipcode, String state, String areacode, String prefix, String suffix){
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.areacode = areacode;
		this.prefix = prefix;
		this.suffix = suffix;	
		
	}
	
	public mystore() {
		// TODO Auto-generated constructor stub
	}

	

	public String getUsfname() {
		return fname;
	}
	public Date getDate() {
		return date;
	}
	public String getUslname() {
		return lname;
	}
	public String getUspass() {
		return password;
	}
	public String getUsemail() {
		return email;
	}
	public String getUsaddst1() {
		return street1;
	}
	public String getstreet2() {
		return street2;
	}
	public String getcity() {
		return city;
	}
	public String getUszip() {
		return zipcode;
	}
	public String getUsstate() {
		return state;
	}
	public String getUsareacode() {
		return areacode;
	}
	public String getUsprefix() {
		return prefix;
	}
	public String getUssuffix() {
		return suffix;
	}
	
	  public void setUsfname( String fname )
	    {
	        this.fname = fname;
	    }
	  public void setUslname( String lname )
	    {
	        this.lname = lname;
	    }
	  public void setUsstate( String state )
	    {
	        this.state = state;
	    }
	  public void setUszip( String zipcode )
	    {
	        this.zipcode = zipcode;
	    }
	  public void setUspass( String password )
	    {
	        this.password = password;
	    }
	  public void setUsemail( String email )
	    {
	        this.email = email;
	    }
	  //-------//-----
	  public void setUsaddst1( String street1 )
	    {
	        this.street1 = street1;
	    }
	  public void setUscity( String city )
	    {
	        this.city = city;
	    }
	  public void setUsareacode( String areacode )
	    {
	        this.areacode = areacode;
	    }
	  public void setUsprefix( String prefix )
	    {
	        this.prefix = prefix;
	    }
	  public void setUssuffix( String suffix )
	    {
	        this.suffix = suffix;
	    }
}
