package com.xiaotong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Dept;
import com.xiaotong.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private IDeptService ids;
	
	@RequestMapping("/selectList")
	@ResponseBody
	public List selectList() {
		List list = null;
		try {
			list = ids.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**查询挂号科室
	 * @return
	 */
	@RequestMapping("/selectGh")
	@ResponseBody
	public List selectGh() {
		List list = null;
		try {
			list = ids.selectGh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Dept d) {
		String result = "0";
		try {
			ids.insert(d);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Dept d) {
		String result = "0";
		try {
			ids.update(d);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String deptid) {
		String result = "0";
		try {
			ids.delete(deptid);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
