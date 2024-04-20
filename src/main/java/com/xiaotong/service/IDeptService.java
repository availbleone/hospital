package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Dept;

public interface IDeptService {
	public void insert(Dept d);
	public void update(Dept d);
	public void delete(String deptid);
	public Dept selectOne(String deptid);
	public List selectList();
	public List selectGh();
}
