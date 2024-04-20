package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Admin;

public interface IAdminService {
	public void insert(Admin a);
	public void update(Admin a);
	public void delete(String aid);
	public Admin selectOne(String aid);
	public List selectList();
	public List selectByDept(String deptid);
}
