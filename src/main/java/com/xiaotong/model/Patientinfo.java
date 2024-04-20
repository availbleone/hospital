package com.xiaotong.model;

public class Patientinfo {
	private String patientno	 ;
	private String idnumber 	 ;
	private String patientname	 ;
	private Integer sex		 	 ;
	private Integer age			 ;
	private String pwd 			 ;
	private String tel			 ;
	private String bz 			 ;
	public String getpatientno() {
		return patientno;
	}
	public void setpatientno(String patientno) {
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Patientinfo [patientno=" + patientno + ", idnumber=" + idnumber + ", patientname=" + patientname
				+ ", sex=" + sex + ", age=" + age + ", pwd=" + pwd + ", tel=" + tel + ", bz=" + bz + "]";
	}
	public Patientinfo(String patientno, String idnumber, String patientname, Integer sex, Integer age, String pwd,
			String tel, String bz) {
		super();
		this.patientno = patientno;
		this.idnumber = idnumber;
		this.patientname = patientname;
		this.sex = sex;
		this.age = age;
		this.pwd = pwd;
		this.tel = tel;
		this.bz = bz;
	}
	public Patientinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
