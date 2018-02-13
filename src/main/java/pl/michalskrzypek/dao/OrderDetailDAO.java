package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.OrderDetail;
import pl.michalskrzypek.entity.OrderItem;

public interface OrderDetailDAO {

	public boolean add(OrderDetail orderDetail);

	public boolean delete(int id);

	public boolean update(OrderDetail order);

	public boolean findById(int id);

	public OrderDetail get(int id);
	
	public List<OrderDetail> listAllOrders(int accountId);
	
	public List<OrderItem> listAllItems(int orderId);
}
