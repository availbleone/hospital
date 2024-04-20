package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IAdminDao;
import com.xiaotong.dao.IPatientinfoDao;
import com.xiaotong.dao.IRegisterDao;
import com.xiaotong.model.Admin;
import com.xiaotong.model.Patientinfo;
import com.xiaotong.model.Register;
import com.xiaotong.service.IAdminService;
import com.xiaotong.service.IPatientinfoService;
import com.xiaotong.service.IRegisterService;
@Service
@Transactional
public class PatientServiceImpl implements IPatientinfoService {
	@Autowired
	private IPatientinfoDao pdao;

	
	public void insert(Integer p) {
		// TODO Auto-generated method stub
		pdao.insert(p);
	}

	
	public void update(Patientinfo p) {
		// TODO Auto-generated method stub
		pdao.update(p);
	}

	
	public void delete(String aid) {
		// TODO Auto-generated method stub
		pdao.delete(aid);
	}

	
	public Patientinfo selectOne(String Patientno) {
		// TODO Auto-generated method stub
		return pdao.selectOne(Patientno);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return pdao.selectList();
	}

	
	public Patientinfo selectByIdnumber(String idnumber) {
		// TODO Auto-generated method stub
		return pdao.selectByIdnumber(idnumber);
	}

	
}
