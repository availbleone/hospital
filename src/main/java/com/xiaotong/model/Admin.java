package com.xiaotong.model;

public class Admin {
	private String aid 	;
	private String aname 	;
	private String apwd  	;
	private String deptid 	;
	private String roleid 	;
	private Integer alevel 	;
	private String bz 		;
	private String dname 		;
	private String rolename 		;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public Integer getAlevel() {
		return alevel;
	}
	public void setAlevel(Integer alevel) {
		this.alevel = alevel;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public Admin(String aid, String aname, String apwd, String deptid, String roleid, Integer alevel, String intro,
			String pic, String bz, String dname, String rolename) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.deptid = deptid;
		this.roleid = roleid;
		this.alevel = alevel;
		this.bz = bz;
		this.dname = dname;
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", apwd=" + apwd + ", deptid=" + deptid + ", roleid=" + roleid
				+ ", alevel=" + alevel + ", bz=" + bz + ", dname=" + dname
				+ ", rolename=" + rolename + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
