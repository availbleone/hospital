package com.xiaotong.controller;

import com.xiaotong.model.Admin;
import com.xiaotong.model.DoctorOrder;
import com.xiaotong.service.DoctorOrderService;
import com.xiaotong.service.IAdminService;
import com.xiaotong.util.MD5util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/nurse")
public class DoctorOrderController {
	@Autowired
	private DoctorOrderService doctorOrderService;

	@GetMapping("/doctorOrders")
	public List<DoctorOrder> getAllOrders() {
		return doctorOrderService.getAllOrders();
	}
	@PostMapping("/executeOrder")
	public Map<String, Object> executeOrder(@RequestParam("id") int id) {
		Map<String, Object> result = new HashMap<>();
		try {
			doctorOrderService.executeOrder(id);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}
	@PostMapping("/deleteOrder")
	public Map<String, Object> deleteOrder(@RequestParam("id") int id) {
		Map<String, Object> result = new HashMap<>();
		try {
			doctorOrderService.deleteOrder(id);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}
}
