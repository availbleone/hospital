package com.xiaotong.service;

import com.xiaotong.model.Admin;
import com.xiaotong.model.DoctorOrder;

import java.util.List;

public interface DoctorOrderService {
	List<DoctorOrder> getAllOrders();
	void executeOrder(int id);

	void deleteOrder(int id);
}
