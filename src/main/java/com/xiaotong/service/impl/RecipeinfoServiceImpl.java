package com.xiaotong.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IFeeinfoDao;
import com.xiaotong.dao.IRecipeinfoDao;
import com.xiaotong.model.Feeinfo;
import com.xiaotong.model.Recipeinfo;
import com.xiaotong.service.IRecipeinfoService;
import com.xiaotong.util.DateUtil;
import com.xiaotong.util.UUIDUtils;
@Service
@Transactional
public class RecipeinfoServiceImpl implements IRecipeinfoService {
	@Autowired
	private IRecipeinfoDao rdao;
	@Autowired
	private IFeeinfoDao fdao;

	
	public void insert(Recipeinfo re) {
		// TODO Auto-generated method stub
		re.setOperatetime(DateUtil.getSysTime());
		re.setSfstate(0);
		re.setZxstate(0);
		/*String fid = UUIDUtils.getUUID();
		re.setFid(fid);*/
		String rid = UUIDUtils.getUUID();
		re.setRid(rid);
		rdao.insert(re);
		/*Feeinfo f = new Feeinfo(fid, re.getPatientno(), re.getRegid(), re.getPatientname(), re.getUnitprice(), 0, DateUtil.getSysTime(), re.getOperatorid(), "");
		fdao.insert(f);*/
	}

	
	public void update(Recipeinfo re) {
		// TODO Auto-generated method stub
		rdao.update(re);
	}

	
	public void delete(String rid) {
		// TODO Auto-generated method stub
		rdao.delete(rid);
	}

	
	public Recipeinfo selectOne(String rid) {
		// TODO Auto-generated method stub
		return rdao.selectOne(rid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return rdao.selectList();
	}

	
	public List selectByProperty(Map map) {
		// TODO Auto-generated method stub
		return rdao.selectByProperty(map);
	}

	
	public void deletexm(String rid,String fid) {
		// TODO Auto-generated method stub
		//fdao.delete(fid);
		rdao.delete(rid);
	}

	
	public List selectDsfList(Map map) {
		// TODO Auto-generated method stub
		return rdao.selectDsfList(map);
	}

	
	public List selectByFid(String fid) {
		// TODO Auto-generated method stub
		return rdao.selectByFid(fid);
	}

	
	public List selectByRegid(Integer regid) {
		// TODO Auto-generated method stub
		return rdao.selectByRegid(regid);
	}

}
