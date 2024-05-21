package com.xiaotong.dao;
import com.xiaotong.model.DoctorOrder;

import java.util.List;

public interface IDoctorOrderDao {
	List<DoctorOrder> getAllOrders();
	void executeOrder(int id);
	void deleteOrder(int id);
}
