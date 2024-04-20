package com.xiaotong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Clinicitem;
import com.xiaotong.service.IClinicitemService;

@Controller
@RequestMapping("/clinicitem")
public class ClinicitemController {
	@Autowired
	private IClinicitemService ics;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Clinicitem c) {
		String result = "0";
		try {
			ics.insert(c);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Clinicitem c) {
		String result = "0";
		try {
			ics.update(c);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer itemid) {
		String result = "0";
		try {
			ics.delete(itemid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/selectList")
	@ResponseBody
	public List selectList() {
		List list = null;
		try {
			list = ics.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**根据输入内容查询检验检查项目
	 * @return
	 */
	@RequestMapping("/selectXm")
	@ResponseBody
	public List selectXm(String flag,String value) {
		List list = null;
		try {
			list = ics.selectXm(flag,value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/selectOne")
	@ResponseBody
	public Clinicitem selectOne(Integer itemid) {
		Clinicitem c = null;
		try {
			c = ics.selectOne(itemid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
