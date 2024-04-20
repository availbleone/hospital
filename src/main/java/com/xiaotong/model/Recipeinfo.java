package com.xiaotong.model;

public class Recipeinfo {
	private String rid 		 ;
	private String patientno 	 ;
	private Integer regid 		 ;
	private String patientname  ;
	private Integer rtype 		 ;
	private String did 		 ;
	private String dname 		 ;
	private Double unitprice 	 ;
	private Integer dnum  		 ;
	private Integer qty 		 ;
	private String freq		 ;
	private String operatorid 	 ;
	private String operatetime	 ;
	private String fid 		 ;
	private Integer sfstate		 ;
	private Integer zxstate		 ;
	private String flag 		 ;
	private String bz			 ;
	private String minunit;			 
	private String unit;			 
	private String idnumber;
	private Integer sex;
	private Integer age;
	private String guige;
	
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMinunit() {
		return minunit;
	}
	public void setMinunit(String minunit) {
		this.minunit = minunit;
	}
	public void setFreq(String freq) {
		this.freq = freq;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
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
	public Integer getRtype() {
		return rtype;
	}
	public void setRtype(Integer rtype) {
		this.rtype = rtype;
	}
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
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getDnum() {
		return dnum;
	}
	public void setDnum(Integer dnum) {
		this.dnum = dnum;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getFreq() {
		return freq;
	}
	public void String(String freq) {
		this.freq = freq;
	}
	public String getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}
	public String getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Integer getSfstate() {
		return sfstate;
	}
	public void setSfstate(Integer sfstate) {
		this.sfstate = sfstate;
	}
	public Integer getZxstate() {
		return zxstate;
	}
	public void setZxstate(Integer zxstate) {
		this.zxstate = zxstate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Recipeinfo [rid=" + rid + ", patientno=" + patientno + ", regid=" + regid + ", patientname="
				+ patientname + ", rtype=" + rtype + ", did=" + did + ", dname=" + dname + ", unitprice=" + unitprice
				+ ", dnum=" + dnum + ", qty=" + qty + ", freq=" + freq + ", operatorid=" + operatorid + ", operatetime="
				+ operatetime + ", fid=" + fid + ", sfstate=" + sfstate + ", zxstate=" + zxstate + ", flag=" + flag
				+ ", bz=" + bz + "]";
	}
	public Recipeinfo(String rid, String patientno, Integer regid, String patientname, Integer rtype, String did,
			String dname, Double unitprice, Integer dnum, Integer qty, String freq, String operatorid,
			String operatetime, String fid, Integer sfstate, Integer zxstate, String flag, String bz) {
		super();
		this.rid = rid;
		this.patientno = patientno;
		this.regid = regid;
		this.patientname = patientname;
		this.rtype = rtype;
		this.did = did;
		this.dname = dname;
		this.unitprice = unitprice;
		this.dnum = dnum;
		this.qty = qty;
		this.freq = freq;
		this.operatorid = operatorid;
		this.operatetime = operatetime;
		this.fid = fid;
		this.sfstate = sfstate;
		this.zxstate = zxstate;
		this.flag = flag;
		this.bz = bz;
	}
	public Recipeinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
