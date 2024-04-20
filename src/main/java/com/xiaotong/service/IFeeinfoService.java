package com.xiaotong.service;

import java.util.List;
import java.util.Map;

import com.xiaotong.model.Feeinfo;

public interface IFeeinfoService {
	public void insert(String[] rid, String aid);
	public void update(Feeinfo f);
	public void delete(String fid);
	public Feeinfo selectOne(String fid);
	public List selectList();
	public List selectDfyList(Map map);
	public void sendDrug(String fid);
	public int selectBytime();
}
