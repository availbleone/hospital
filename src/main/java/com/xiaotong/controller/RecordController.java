package com.xiaotong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Record;
import com.xiaotong.service.IRecordService;

@Controller
@CrossOrigin
@RequestMapping("/record")
public class RecordController {
	@Autowired
	private IRecordService irs;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Record r) {
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
	
	@RequestMapping("/selectByPno")
	@ResponseBody
	public List selectByPno(String pno) {
		List list =null;
		try {
			list = irs.selectByPno(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
