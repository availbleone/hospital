package com.xiaotong.model;

public class Clinicitem {
	private Integer itemid ;
	private String iname  ;
	private Double iprice ;
	private Integer ctype  ;
	private Integer cstate ;
	private String pcode  ;
	private String bz     ;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public Double getIprice() {
		return iprice;
	}
	public void setIprice(Double iprice) {
		this.iprice = iprice;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getCstate() {
		return cstate;
	}
	public void setCstate(Integer cstate) {
		this.cstate = cstate;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Clinicitem [itemid=" + itemid + ", iname=" + iname + ", iprice=" + iprice + ", ctype=" + ctype
				+ ", cstate=" + cstate + ", pcode=" + pcode + ", bz=" + bz + "]";
	}
	public Clinicitem(Integer itemid, String iname, Double iprice, Integer ctype, Integer cstate, String pcode,
			String bz) {
		super();
		this.itemid = itemid;
		this.iname = iname;
		this.iprice = iprice;
		this.ctype = ctype;
		this.cstate = cstate;
		this.pcode = pcode;
		this.bz = bz;
	}
	public Clinicitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
