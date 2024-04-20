package com.xiaotong.model;

public class Dept {
	private String deptid;
	private String dname;
	private Integer dtype;
	private String dloc;
	private String bz;
	
	public Integer getDtype() {
		return dtype;
	}
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", dname=" + dname + ", dtype=" + dtype + ", dloc=" + dloc + ", bz=" + bz
				+ "]";
	}
	public Dept(String deptid, String dname, Integer dtype, String dloc, String bz) {
		super();
		this.deptid = deptid;
		this.dname = dname;
		this.dtype = dtype;
		this.dloc = dloc;
		this.bz = bz;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
