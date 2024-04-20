package com.xiaotong.model;

public class Druginfo {
	private String did;
	private String dname;
	private Integer dtype;
	private String unit ;
	private Integer unitnum ;
	private String minunit ;
	private Double price;
	private String provider;
	private String deadline;
	private Integer dstate;
	private String pcode;
	private Integer dnum;
	private String bz	;
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getDtype() {
		return dtype;
	}
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getUnitnum() {
		return unitnum;
	}
	public void setUnitnum(Integer unitnum) {
		this.unitnum = unitnum;
	}
	public String getMinunit() {
		return minunit;
	}
	public void setMinunit(String minunit) {
		this.minunit = minunit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Integer getDstate() {
		return dstate;
	}
	public void setDstate(Integer dstate) {
		this.dstate = dstate;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public Integer getDnum() {
		return dnum;
	}
	public void setDnum(Integer dnum) {
		this.dnum = dnum;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Druginfo [did=" + did + ", dname=" + dname + ", dtype=" + dtype + ", unit=" + unit + ", unitnum="
				+ unitnum + ", minunit=" + minunit + ", price=" + price + ", provider=" + provider + ", deadline="
				+ deadline + ", dstate=" + dstate + ", pcode=" + pcode + ", dnum=" + dnum + ", bz=" + bz + "]";
	}
	public Druginfo(String did, String dname, Integer dtype, String unit, Integer unitnum, String minunit, Double price,
			String provider, String deadline, Integer dstate, String pcode, Integer dnum, String bz) {
		super();
		this.did = did;
		this.dname = dname;
		this.dtype = dtype;
		this.unit = unit;
		this.unitnum = unitnum;
		this.minunit = minunit;
		this.price = price;
		this.provider = provider;
		this.deadline = deadline;
		this.dstate = dstate;
		this.pcode = pcode;
		this.dnum = dnum;
		this.bz = bz;
	}
	public Druginfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
