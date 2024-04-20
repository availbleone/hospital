package com.xiaotong.dao;

import java.util.List;
import java.util.Map;

import com.xiaotong.model.Recipeinfo;

public interface IRecipeinfoDao {
	public void insert(Recipeinfo re);
	public void update(Recipeinfo re);
	public void delete(String rid);
	public Recipeinfo selectOne(String rid);
	public List selectList();
	public void insertGh(Recipeinfo re);
	public List selectByProperty(Map map);
	public List selectDsfList(Map map);
	public List selectSfList(String[] rid);
	public void updateFid(Map map);
	public List selectByFid(String fid);
	public void updateZxState(String fid);
	public List selectByRegid(Integer regid);
}
