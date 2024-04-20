package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IAdminDao;
import com.xiaotong.model.Admin;
import com.xiaotong.service.IAdminService;
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminDao adao;

	
	public void insert(Admin a) {
		// TODO Auto-generated method stub
		adao.insert(a);
	}

	
	public void update(Admin a) {
		// TODO Auto-generated method stub
		adao.update(a);
	}

	
	public void delete(String aid) {
		// TODO Auto-generated method stub
		adao.delete(aid);
	}

	
	public Admin selectOne(String aid) {
		// TODO Auto-generated method stub
		return adao.selectOne(aid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return adao.selectList();
	}

	
	public List selectByDept(String deptid) {
		// TODO Auto-generated method stub
		return adao.selectByDept(deptid);
	}

}
