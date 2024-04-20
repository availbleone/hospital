package com.xiaotong.dao;

import java.util.List;

import com.xiaotong.model.Patientinfo;

public interface IPatientinfoDao {
	public void insert(Integer p);
	public void update(Patientinfo p);
	public void delete(String aid);
	public Patientinfo selectOne(String Patientno);
	public List selectList();
	public Patientinfo selectByIdnumber(String idnumber);
}
