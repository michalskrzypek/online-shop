package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.Category;
import pl.michalskrzypek.entity.OrderDetail;
import pl.michalskrzypek.entity.OrderItem;

public interface OrderItemDAO {

	public boolean add(OrderItem orderItem);

	public boolean delete(int id);

	public boolean update(OrderItem orderItem);

	public List<OrderItem> list(int orderDetailId);

	public OrderItem get(int id);
	
}
