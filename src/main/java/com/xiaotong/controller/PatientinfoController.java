package com.xiaotong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.model.Patientinfo;
import com.xiaotong.service.IPatientinfoService;

@Controller
@RequestMapping("/patientinfo")
public class PatientinfoController {
	@Autowired
	private IPatientinfoService ips;
	
	@RequestMapping("/selectOne")
	@ResponseBody
	public Patientinfo selectOne(String patientno) {
		Patientinfo p = null;
		try {
			p = ips.selectOne(patientno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	@RequestMapping("/selectByIdnumber")
	@ResponseBody
	public Patientinfo selectByIdnumber(String idnumber) {
		Patientinfo p = null;
		try {
			p = ips.selectByIdnumber(idnumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
