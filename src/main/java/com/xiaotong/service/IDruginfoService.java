package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Druginfo;

public interface IDruginfoService {
	public void insert(Druginfo d);
	public void update(Druginfo d);
	public void delete(String did);
	public Druginfo selectOne(String did);
	public List selectList();
	public List selectYp(String value);
}
