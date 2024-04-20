package com.xiaotong.model;

public class Record {
	private Integer recordid 	;
	private String patientno 	;
	private Integer regid 		;
	private String patientname ;
	private String symptom		;
	private String history		;
	private Double temperature	;
	private String bloodpre  	;
	private String measure		;
	private String diagnose 	;
	private String operatorid 	;
	private String operatetime	;
	private String bz 			;
	public Integer getRecordid() {
		return recordid;
	}
	public void setRecordid(Integer recordid) {
		this.recordid = recordid;
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
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public String getBloodpre() {
		return bloodpre;
	}
	public void setBloodpre(String bloodpre) {
		this.bloodpre = bloodpre;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public String toString() {
		return "Record [recordid=" + recordid + ", patientno=" + patientno + ", regid=" + regid + ", patientname="
				+ patientname + ", symptom=" + symptom + ", history=" + history + ", temperature=" + temperature
				+ ", bloodpre=" + bloodpre + ", measure=" + measure + ", diagnose=" + diagnose + ", operatorid="
				+ operatorid + ", operatetime=" + operatetime + ", bz=" + bz + "]";
	}
	public Record(Integer recordid, String patientno, Integer regid, String patientname, String symptom, String history,
			Double temperature, String bloodpre, String measure, String diagnose, String operatorid,
			String operatetime, String bz) {
		super();
		this.recordid = recordid;
		this.patientno = patientno;
		this.regid = regid;
		this.patientname = patientname;
		this.symptom = symptom;
		this.history = history;
		this.temperature = temperature;
		this.bloodpre = bloodpre;
		this.measure = measure;
		this.diagnose = diagnose;
		this.operatorid = operatorid;
		this.operatetime = operatetime;
		this.bz = bz;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
