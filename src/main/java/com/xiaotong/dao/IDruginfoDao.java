package com.xiaotong.dao;

import java.util.List;
import java.util.Map;

import com.xiaotong.model.Druginfo;

public interface IDruginfoDao {
	public void insert(Druginfo d);
	public void update(Druginfo d);
	public void delete(String did);
	public Druginfo selectOne(String did);
	public List selectList();
	public List selectYp(String value);
	public void updateDnum(Map map);
}
