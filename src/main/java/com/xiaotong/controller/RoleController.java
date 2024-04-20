package com.xiaotong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Dept;
import com.xiaotong.model.Role;
import com.xiaotong.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService irs;
	
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
		return list;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Role r) {
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
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Role r) {
		String result = "0";
		try {
			irs.update(r);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String roleid) {
		String result = "0";
		try {
			irs.delete(roleid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
