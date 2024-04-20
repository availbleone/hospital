package com.xiaotong.service;

import java.util.List;

import com.xiaotong.model.Clinicitem;

public interface IClinicitemService {
	public void insert(Clinicitem c);
	public void update(Clinicitem c);
	public void delete(Integer itemid);
	public Clinicitem selectOne(Integer itemid);
	public List selectList();
	public List selectXm(String flag, String value);
}
