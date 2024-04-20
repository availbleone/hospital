package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IDeptDao;
import com.xiaotong.dao.IRoleDao;
import com.xiaotong.model.Dept;
import com.xiaotong.model.Role;
import com.xiaotong.service.IDeptService;
import com.xiaotong.service.IRoleService;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao rdao;

	
	public void insert(Role r) {
		// TODO Auto-generated method stub
		rdao.insert(r);
	}

	
	public void update(Role r) {
		// TODO Auto-generated method stub
		rdao.update(r);
	}

	
	public void delete(String roleid) {
		// TODO Auto-generated method stub
		rdao.delete(roleid);
	}

	
	public Role selectOne(String roleid) {
		// TODO Auto-generated method stub
		return rdao.selectOne(roleid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return rdao.selectList();
	}
	
}
