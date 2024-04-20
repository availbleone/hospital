package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IDeptDao;
import com.xiaotong.model.Dept;
import com.xiaotong.service.IDeptService;
@Service
@Transactional
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptDao ddao;
	
	public void insert(Dept d) {
		// TODO Auto-generated method stub
		ddao.insert(d);
	}

	
	public void update(Dept d) {
		// TODO Auto-generated method stub
		ddao.update(d);
	}

	
	public void delete(String deptid) {
		// TODO Auto-generated method stub
		ddao.delete(deptid);
	}

	
	public Dept selectOne(String deptid) {
		// TODO Auto-generated method stub
		return ddao.selectOne(deptid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return ddao.selectList();
	}

	
	public List selectGh() {
		// TODO Auto-generated method stub
		return ddao.selectGh();
	}

}
