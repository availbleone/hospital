package com.xiaotong.controller;

import com.xiaotong.model.DoctorOrder;
import com.xiaotong.service.IDoctorOrderService;
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
	private IDoctorOrderService IDoctorOrderService;

	@RequestMapping( "/doctorOrders")
	@ResponseBody
	public List<DoctorOrder> getDoctorOrders() {
		System.out.println("Fetched Orders: 1111111111111111111111111111111111111111");
		List<DoctorOrder> orders = IDoctorOrderService.getAllOrders();
		System.out.println("Fetched Orders: 1111111111111111111111111111111111111111" + orders); // 打印查询结果
		return orders;
	}
	@PostMapping("/doctorOrders")
	@ResponseBody
	public List<DoctorOrder> postDoctorOrders() {
		return IDoctorOrderService.getAllOrders();
	}
	@RequestMapping( "/executeOrder")
	@ResponseBody
	public Map<String, Object> executeOrder(@RequestParam("id") int id) {
		Map<String, Object> result = new HashMap<>();
		try {
			IDoctorOrderService.executeOrder(id);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}
	@RequestMapping( "/deleteOrder")
	@ResponseBody
	public Map<String, Object> deleteOrder(@RequestBody Map<String, Integer> request) {
		int id = request.get("id");
		Map<String, Object> response = new HashMap<>();
		try {
			IDoctorOrderService.deleteOrder(id);
			response.put("success", true);
		} catch (Exception e) {
			response.put("success", false);
		}
		return response;
	}
}
