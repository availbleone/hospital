package com.xiaotong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.service.IFeeinfoService;


@Controller
@RequestMapping("/feeinfo")
@CrossOrigin
public class FeeinfoController {
	@Autowired
	private IFeeinfoService ifs;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String Insert(String rids,String aid) {
		String result="0";
		try {
			String[] rid = rids.split(",");
			ifs.insert(rid,aid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**查询待发药患者列表
	 * @param pno
	 * @param idno
	 * @return
	 */
	@RequestMapping("/selectDfyList")
	@ResponseBody
	public List selectDfyList(String pno,String idno) {
		List list = null;
		Map map = new HashMap();
		map.put("pno", pno);
		map.put("idno", idno);
		try {
			list = ifs.selectDfyList(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**发药功能
	 * @param fid
	 * @return
	 */
	@RequestMapping("/sendDrug")
	@ResponseBody
	public String sendDrug(String fid) {
		String result = "0";
		try {
			ifs.sendDrug(fid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
