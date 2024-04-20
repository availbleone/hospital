package com.xiaotong.dao;

import java.util.List;

import com.xiaotong.model.Record;

public interface IRecordDao {
	public void insert(Record r);
	public void update(Record r);
	public void delete(Integer recordid);
	public Record selectOne(String recordid);
	public List selectList();
	public List selectByPno(String pno);
}
