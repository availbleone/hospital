package com.xiaotong.model;

public class Register {
	private Integer regid		 ;
	private String patientno	 ;
	private String idnumber 	 ;
	private String patientname	 ;
	private Integer sex			 ;
	private Integer age			 ;
	private String regdate		 ;
	private String deptid		 ;
	private String aid			 ;
	private Integer state		 ;
	private String operatorid	 ;
	private String bz 			 ;
	private String dname;
	private String aname;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getRegid() {
		return regid;
	}
	public void setRegid(Integer regid) {
		this.regid = regid;
	}
	public String getPatientno() {
		return patientno;
	}
	public void setPatientno(String patientno) {
		this.patientno = patientno;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Register [regid=" + regid + ", patientno=" + patientno + ", idnumber=" + idnumber + ", patientname="
				+ patientname + ", sex=" + sex + ", age=" + age + ", regdate=" + regdate + ", deptid=" + deptid
				+ ", aid=" + aid + ", state=" + state + ", operatorid=" + operatorid + ", bz=" + bz + "]";
	}
	public Register(Integer regid, String patientno, String idnumber, String patientname, Integer sex, Integer age,
			String regdate, String deptid, String aid, Integer state, String operatorid, String bz) {
		super();
		this.regid = regid;
		this.patientno = patientno;
		this.idnumber = idnumber;
		this.patientname = patientname;
		this.sex = sex;
		this.age = age;
		this.regdate = regdate;
		this.deptid = deptid;
		this.aid = aid;
		this.state = state;
		this.operatorid = operatorid;
		this.bz = bz;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
