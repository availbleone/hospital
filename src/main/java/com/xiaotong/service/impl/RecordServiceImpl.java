package com.xiaotong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IRecordDao;
import com.xiaotong.dao.IRegisterDao;
import com.xiaotong.model.Record;
import com.xiaotong.service.IRecordService;
@Service
@Transactional
public class RecordServiceImpl implements IRecordService {
	@Autowired
	private IRecordDao rdao;
	@Autowired
	private IRegisterDao irdao; 

	
	public void insert(Record r) {
		// TODO Auto-generated method stub
		rdao.insert(r);
		//修改患者就诊状态为已诊
		//irdao.updateState(r.getRegid());
	}

	
	public void update(Record r) {
		// TODO Auto-generated method stub
		rdao.update(r);
	}

	
	public void delete(Integer recordid) {
		// TODO Auto-generated method stub
		rdao.delete(recordid);
	}

	
	public Record selectOne(String recordid) {
		// TODO Auto-generated method stub
		return rdao.selectOne(recordid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return rdao.selectList();
	}

	
	public List selectByPno(String pno) {
		// TODO Auto-generated method stub
		return rdao.selectByPno(pno);
	}
	
}
