package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Patientinfo;

public interface IPatientinfoService {
	public void insert(Integer p);
	public void update(Patientinfo p);
	public void delete(String aid);
	public Patientinfo selectOne(String Patientno);
	public List selectList();
	public Patientinfo selectByIdnumber(String idnumber);
}
