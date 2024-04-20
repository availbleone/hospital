package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Register;

public interface IRegisterService {
	public void insert(Register r);
	public void update(Register r);
	public void delete(Integer regid);
	public Register selectOne(Integer regid);
	public List selectList();
	public List selectDz(String aid);
	public void updateState(Integer regid);
	public List selectLast();
}
