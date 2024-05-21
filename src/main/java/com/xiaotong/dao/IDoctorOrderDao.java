package com.xiaotong.dao;
import com.xiaotong.model.DoctorOrder;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

public interface IDoctorOrderDao {
	List<DoctorOrder> getAllOrders();

	void executeOrder(int id);

	void deleteOrder(int id);
}
