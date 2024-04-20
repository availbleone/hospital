package com.xiaotong.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotong.dao.IDruginfoDao;
import com.xiaotong.dao.IFeeinfoDao;
import com.xiaotong.dao.IRecipeinfoDao;
import com.xiaotong.model.Druginfo;
import com.xiaotong.model.Feeinfo;
import com.xiaotong.model.Recipeinfo;
import com.xiaotong.service.IFeeinfoService;
import com.xiaotong.util.DateUtil;
import com.xiaotong.util.UUIDUtils;
@Service
@Transactional
public class FeeinfoServiceImpl implements IFeeinfoService {
	@Autowired
	private IFeeinfoDao fdao;
	@Autowired
	private IRecipeinfoDao rdao;
	@Autowired
	private IDruginfoDao ddao;

	
	public void update(Feeinfo f) {
		// TODO Auto-generated method stub
		fdao.update(f);
	}

	
	public void delete(String fid) {
		// TODO Auto-generated method stub
		fdao.delete(fid);
	}

	
	public Feeinfo selectOne(String fid) {
		// TODO Auto-generated method stub
		return fdao.selectOne(fid);
	}

	
	public List selectList() {
		// TODO Auto-generated method stub
		return fdao.selectList();
	}
	
	public void insert(String[] rid, String aid) {
		// TODO Auto-generated method stub
		double total = 0;
		List<Recipeinfo> rlist = rdao.selectSfList(rid);
		//计算总价
		for (Recipeinfo re : rlist) {
			total += re.getUnitprice()*re.getDnum();
		}
		String fid = UUIDUtils.getUUID();
		String paytime = DateUtil.getSysTime();
		Feeinfo fee = new Feeinfo(fid, rlist.get(0).getPatientno(), rlist.get(0).getRegid(), rlist.get(0).getPatientname(), total, 1, paytime, aid, "");
		//插入费用表数据
		fdao.insert(fee);
		//更新费用明细表数据
		Map map = new HashMap();
		map.put("rid", rid);
		map.put("fid", fid);
		rdao.updateFid(map);
	}

	
	public List selectDfyList(Map map) {
		// TODO Auto-generated method stub
		return fdao.selectDfyList(map);
	}

	
	public void sendDrug(String fid) {
		// TODO Auto-generated method stub
		//判断药品库存，若库存充足则更新药品库存
		Map map = new HashMap();
		List<Recipeinfo> rlist = rdao.selectByFid(fid);
		for (Recipeinfo re : rlist) {
			Druginfo dg = ddao.selectOne(re.getDid());
			if(dg.getDnum()<re.getDnum()) {
				throw new RuntimeException("药品库存不足！");
			}
			map.put("did", re.getDid());
			map.put("dnum", re.getDnum()*(-1));
			ddao.updateDnum(map);
		}
		//更新医嘱表执行状态
		rdao.updateZxState(fid);
	}

	
	public int selectBytime() {
		// TODO Auto-generated method stub
		return fdao.selectBytime();
	}

}
