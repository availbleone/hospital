package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Dept;
import com.xiaotong.model.Role;

public interface IRoleService {
	public void insert(Role r);
	public void update(Role r);
	public void delete(String roleid);
	public Role selectOne(String roleid);
	public List selectList();
}
