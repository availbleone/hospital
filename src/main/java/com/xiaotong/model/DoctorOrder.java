package com.xiaotong.model;

import java.util.Date;

public class DoctorOrder {
	private int id;
	private String patientName;
	private String doctorName;
	private String medicationInfo;
	private Date orderTime;
	private String orderInfo;

	// 构造函数、getter 和 setter 方法省略

	// Getter 和 Setter 方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMedicationInfo() {
		return medicationInfo;
	}

	public void setMedicationInfo(String medicationInfo) {
		this.medicationInfo = medicationInfo;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
}
