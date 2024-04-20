package com.xiaotong.dao;

import java.util.List;
import java.util.Map;

import com.xiaotong.model.Feeinfo;

public interface IFeeinfoDao {
	public void insert(Feeinfo f);
	public void update(Feeinfo f);
	public void delete(String fid);
	public Feeinfo selectOne(String fid);
	public List selectList();
	public void insertGh(Feeinfo f);
	public List selectDfyList(Map map);
	public int selectBytime();
}
