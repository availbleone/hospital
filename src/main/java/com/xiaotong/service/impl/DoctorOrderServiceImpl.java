package com.xiaotong.service.impl;

import com.xiaotong.dao.IDoctorOrderDao;
import com.xiaotong.model.DoctorOrder;
import com.xiaotong.service.IDoctorOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorOrderServiceImpl implements IDoctorOrderService {
	@Autowired
	private IDoctorOrderDao doctorOrderDao;
	@Override
	public List<DoctorOrder> getAllOrders() {
		List<DoctorOrder> orders = doctorOrderDao.getAllOrders();
		System.out.println("Service Layer Orders: " + orders); // 打印查询结果
		return orders;
	}

	@Override
	public void executeOrder(int id) {
		doctorOrderDao.executeOrder(id);
	}

	@Override
	public void deleteOrder(int id) {
		doctorOrderDao.deleteOrder(id);
	}

}
