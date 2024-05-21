package com.xiaotong.service.impl;

import com.xiaotong.dao.IAdminDao;
import com.xiaotong.dao.IDoctorOrderDao;
import com.xiaotong.model.Admin;
import com.xiaotong.model.DoctorOrder;
import com.xiaotong.service.DoctorOrderService;
import com.xiaotong.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorOrderServiceImpl implements DoctorOrderService {
	@Autowired
	private IDoctorOrderDao doctorOrderDao;
	@Override
	public List<DoctorOrder> getAllOrders() {
		return doctorOrderDao.getAllOrders();
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
