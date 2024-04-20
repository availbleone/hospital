package com.xiaotong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Recipeinfo;
import com.xiaotong.service.IRecipeinfoService;

@Controller
@RequestMapping("/recipeinfo")
public class RecipeinfoController {
	@Autowired
	private IRecipeinfoService irs;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Recipeinfo re) {
		String result = "0";
		try {
			irs.insert(re);
			System.out.println(re);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/deletexm")
	@ResponseBody
	public String deletexm(String rid,String fid) {
		String result = "0";
		try {
			irs.deletexm(rid,fid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**查询本次医嘱内容
	 * @param regid rtype
	 * @return
	 */
	@RequestMapping("/selectByProperty")
	@ResponseBody
	public List selectByProperty(Integer regid,Integer rtype) {
		List list = null;
		try {
			Map map = new HashMap();
			map.put("regid", regid);
			map.put("rtype", rtype);
			list = irs.selectByProperty(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**查询待收费患者列表
	 * @return
	 */
	@RequestMapping("/selectDsfList")
	@ResponseBody
	public List selectDsfList(String pno,String idno,String pname) {
		List list = null;
		Map map = new HashMap();
		map.put("pno", pno);
		map.put("idno", idno);
		map.put("pname", pname);
		try {
			list = irs.selectDsfList(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**根据fid查询待发药信息
	 * @param fid
	 * @return
	 */
	@RequestMapping("/selectByFid")
	@ResponseBody
	public List selectByFid(String fid) {
		List list = null;
		try {
			list = irs.selectByFid(fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**根据regid查询医嘱信息
	 * @param fid
	 * @return
	 */
	@RequestMapping("/selectByRegid")
	@ResponseBody
	public List selectByRegid(Integer regid) {
		List list = null;
		try {
			list = irs.selectByRegid(regid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
