package com.xiaotong.model;

public class Feeinfo {
	private String fid			 ;
	private String patientno 	 ;
	private Integer regid 		 ;
	private String patientname  ;
	private Double totalcost 	 ;
	private Integer feestate 	 ;
	private String paytime 	 ;
	private String operatorid 	 ;
	private String bz 			 ;
	private String idnumber ;
	private Integer sex 	;
	private Integer age 	;
	private String diagnose ;
	
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getPatientno() {
		return patientno;
	}
	public void setPatientno(String patientno) {
		this.patientno = patientno;
	}
	public Integer getRegid() {
		return regid;
	}
	public void setRegid(Integer regid) {
		this.regid = regid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public Double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}
	public Integer getFeestate() {
		return feestate;
	}
	public void setFeestate(Integer feestate) {
		this.feestate = feestate;
	}
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
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
		return "Feeinfo [fid=" + fid + ", patientno=" + patientno + ", regid=" + regid + ", patientname=" + patientname
				+ ", totalcost=" + totalcost + ", feestate=" + feestate + ", paytime=" + paytime + ", operatorid="
				+ operatorid + ", bz=" + bz + "]";
	}
	public Feeinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feeinfo(String fid, String patientno, Integer regid, String patientname, Double totalcost, Integer feestate,
			String paytime, String operatorid, String bz) {
		super();
		this.fid = fid;
		this.patientno = patientno;
		this.regid = regid;
		this.patientname = patientname;
		this.totalcost = totalcost;
		this.feestate = feestate;
		this.paytime = paytime;
		this.operatorid = operatorid;
		this.bz = bz;
	}
	
}
