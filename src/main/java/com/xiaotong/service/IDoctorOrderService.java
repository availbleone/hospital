package com.xiaotong.service;

import com.xiaotong.model.DoctorOrder;

import java.util.List;

public interface IDoctorOrderService {
	List<DoctorOrder> getAllOrders();
	void executeOrder(int id);
	void deleteOrder(int id);
}
