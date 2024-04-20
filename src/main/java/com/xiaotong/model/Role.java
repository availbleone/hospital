package com.xiaotong.model;

public class Role {
	private String roleid;
	private String rolename;
	private String bz;
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", bz=" + bz + "]";
	}
	public Role(String roleid, String rolename, String bz) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.bz = bz;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
