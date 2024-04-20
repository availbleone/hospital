package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IDeptDao;
import com.xiaotong.dao.IDruginfoDao;
import com.xiaotong.dao.IRoleDao;
import com.xiaotong.model.Dept;
import com.xiaotong.model.Druginfo;
import com.xiaotong.model.Role;
import com.xiaotong.service.IDeptService;
import com.xiaotong.service.IDruginfoService;
import com.xiaotong.service.IRoleService;
@Service
@Transactional
public class DruginfoServiceImpl implements IDruginfoService {
	@Autowired
	private IDruginfoDao ddao;

	
	public void insert(Druginfo d) {
		// TODO Auto-generated method stub
		ddao.insert(d);
	}

	
	public void update(Druginfo d) {
		// TODO Auto-generated method stub
		ddao.update(d);
	}

	
	public void delete(String did) {
		// TODO Auto-generated method stub
		ddao.delete(did);
	}

	
	public Druginfo selectOne(String did) {
		// TODO Auto-generated method stub
		return ddao.selectOne(did);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return ddao.selectList();
	}

	
	public List selectYp(String value) {
		// TODO Auto-generated method stub
		return ddao.selectYp(value);
	}

	
}
