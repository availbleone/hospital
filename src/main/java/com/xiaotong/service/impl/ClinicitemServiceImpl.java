package com.xiaotong.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IClinicitemDao;
import com.xiaotong.model.Clinicitem;
import com.xiaotong.service.IClinicitemService;
@Service
@Transactional
public class ClinicitemServiceImpl implements IClinicitemService {
	@Autowired
	private IClinicitemDao cdao;

	
	public void insert(Clinicitem c) {
		// TODO Auto-generated method stub
		cdao.insert(c);
	}

	
	public void update(Clinicitem c) {
		// TODO Auto-generated method stub
		cdao.update(c);
	}

	
	public void delete(Integer itemid) {
		// TODO Auto-generated method stub
		cdao.delete(itemid);
	}

	
	public Clinicitem selectOne(Integer itemid) {
		// TODO Auto-generated method stub
		return cdao.selectOne(itemid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return cdao.selectList();
		
	}

	
	public List selectXm(String flag, String value) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("flag", flag);
		map.put("value", value);
		return cdao.selectXm(map);
	}

	
	
}
