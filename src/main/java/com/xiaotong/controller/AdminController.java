package com.xiaotong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Admin;
import com.xiaotong.service.IAdminService;
import com.xiaotong.util.MD5util;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService ias;
	
	@RequestMapping("/selectList")
	@ResponseBody
	public List selectList() {
		List list = null;
		try {
			list = ias.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/selectLogin")
	@ResponseBody
	public Admin selectLogin(String aid,String apwd) {
		Admin a = null;
		try {
			String pwd = MD5util.string2MD5(apwd);
			a = ias.selectOne(aid);
			if(a!=null&&a.getApwd().equals(pwd)) {
				a.setApwd("");
				
			}else {
				a = null;
			}
			System.out.println(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	/**根据科室查医生
	 * @return
	 */
	@RequestMapping("/selectByDept")
	@ResponseBody
	public List selectByDept(String deptid) {
		List list = null;
		try {
			list = ias.selectByDept(deptid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Admin a) {
		String result = "0";
		try {
			a.setApwd(MD5util.string2MD5(a.getApwd()));
			ias.insert(a);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Admin a) {
		String result = "0";
		try {
			Admin a1 = ias.selectOne(a.getAid());
			if(a.getApwd()!=null&&a.getApwd()!=""&&!a.getApwd().equals(a1.getApwd())) {
				a.setApwd(MD5util.string2MD5(a.getApwd())); 
			}
			ias.update(a);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String aid) {
		String result = "0";
		try {
			ias.delete(aid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
