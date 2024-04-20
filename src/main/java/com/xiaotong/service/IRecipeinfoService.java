package com.xiaotong.service;

import java.util.List;
import java.util.Map;

import com.xiaotong.model.Recipeinfo;

public interface IRecipeinfoService {
	public void insert(Recipeinfo re);
	public void update(Recipeinfo re);
	public void delete(String rid);
	public Recipeinfo selectOne(String rid);
	public List selectList();
	public List selectByProperty(Map map);
	public void deletexm(String rid, String fid);
	public List selectDsfList(Map map);
	public List selectByFid(String fid);
	public List selectByRegid(Integer regid);
}
