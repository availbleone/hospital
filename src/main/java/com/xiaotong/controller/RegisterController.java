package com.xiaotong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Register;
import com.xiaotong.service.IRegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired 
	private IRegisterService irs;
	
	@RequestMapping("/selectLast")
	@ResponseBody
	public List selectLast() {
		List list = null;
		try {
			list = irs.selectLast();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("selectLast...");
		for (Object object : list) {
			System.out.println(object);
		}
		return list;
	}
	@RequestMapping("/selectList")
	@ResponseBody
	public List selectList() {
		List list = null;
		try {
			list = irs.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("selectList...");
		for (Object object : list) {
			System.out.println(object);
		}
		return list;
	}
	
	/**查询待诊患者列表
	 * @return
	 */
	@RequestMapping("/selectDz")
	@ResponseBody
	public List selectDz(String aid) {
		List list = null;
		try {
			list = irs.selectDz(aid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("selectDz...");
		for (Object object : list) {
			System.out.println(object);
		}
		return list;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Register r) {
		String result = "0";
		try {
			irs.insert(r);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/updateState")
	@ResponseBody
	public String updateState(Integer regid) {
		String result = "0";
		try {
			irs.updateState(regid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
