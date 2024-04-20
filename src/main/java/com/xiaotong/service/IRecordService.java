package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Dept;
import com.xiaotong.model.Record;
import com.xiaotong.model.Role;

public interface IRecordService {
	public void insert(Record r);
	public void update(Record r);
	public void delete(Integer recordid);
	public Record selectOne(String recordid);
	public List selectList();
	public List selectByPno(String pno);
}
