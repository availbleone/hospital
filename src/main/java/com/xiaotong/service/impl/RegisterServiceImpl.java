package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IFeeinfoDao;
import com.xiaotong.dao.IPatientinfoDao;
import com.xiaotong.dao.IRecipeinfoDao;
import com.xiaotong.dao.IRegisterDao;
import com.xiaotong.model.Feeinfo;
import com.xiaotong.model.Recipeinfo;
import com.xiaotong.model.Register;
import com.xiaotong.service.IRegisterService;
import com.xiaotong.util.DateUtil;
import com.xiaotong.util.UUIDUtils;
@Service
@Transactional
public class RegisterServiceImpl implements IRegisterService {
	@Autowired
	private IRegisterDao rdao;
	@Autowired
	private IPatientinfoDao pdao;
	@Autowired
	private IFeeinfoDao fdao;
	@Autowired
	private IRecipeinfoDao redao;
	
	
	public void insert(Register r) {
		// TODO Auto-generated method stub
		Integer regid = rdao.selectSeq();
		r.setRegid(regid);
		//插入挂号表数据
		r.setState(0);
		rdao.insert(r);
		//如果患者无病历号，需向患者信息表插入数据
		if(r.getPatientno().equals("")) {
			pdao.insert(regid);
		}
		//插入费用表
		String fid = UUIDUtils.getUUID();
		String time = DateUtil.getSysTime();
		Feeinfo f = new Feeinfo(fid, "", regid, "", 10.00, 1, time, "", "");
		fdao.insertGh(f);
		//插入费用明细表数据
		String rid = UUIDUtils.getUUID();
		Recipeinfo re = new Recipeinfo(rid, "", regid, "", 0, "1", "挂号费", 10.00, 1, 1, "其他", "", time, fid, 1, 1, "", "");
		redao.insertGh(re);
	}

	
	public void update(Register r) {
		// TODO Auto-generated method stub
		rdao.update(r);
	}

	
	public void delete(Integer regid) {
		// TODO Auto-generated method stub
		rdao.delete(regid);
	}

	
	public Register selectOne(Integer regid) {
		// TODO Auto-generated method stub
		return rdao.selectOne(regid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return rdao.selectList();
	}

	
	public List selectDz(String aid) {
		// TODO Auto-generated method stub
		return rdao.selectDz(aid);
	}

	
	public void updateState(Integer regid) {
		// TODO Auto-generated method stub
		rdao.updateState(regid);
	}


	public List selectLast() {
		// TODO Auto-generated method stub
		return rdao.selectLast();
	}

	
}
