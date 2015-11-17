package finals;

import java.util.Date;

public class library {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String medianame;
	private Date dateadded;
	private String borower;
	private Date boroweddate;
	private String type;
	public library(int id,String medianame, Date dateadded, String borower,
			Date boroweddate, String type) {
		super();
		this.id=id;
		this.medianame = medianame;
		this.dateadded = dateadded;
		this.borower = borower;
		this.boroweddate = boroweddate;
		this.type = type;
	}
	public String getMedianame() {
		return medianame;
	}
	public void setMedianame(String medianame) {
		this.medianame = medianame;
	}
	public Date getDateadded() {
		return dateadded;
	}
	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}
	public String getBorower() {
		return borower;
	}
	public void setBorower(String borower) {
		this.borower = borower;
	}
	public Date getBoroweddate() {
		return boroweddate;
	}
	public void setBoroweddate(Date boroweddate) {
		this.boroweddate = boroweddate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
