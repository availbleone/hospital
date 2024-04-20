package com.xiaotong.dao;

import java.util.List;
import java.util.Map;

import com.xiaotong.model.Clinicitem;

public interface IClinicitemDao {
	public void insert(Clinicitem c);
	public void update(Clinicitem c);
	public void delete(Integer itemid);
	public Clinicitem selectOne(Integer itemid);
	public List selectList();
	public List selectXm(Map map);
}
