package spring_06_mvc.sec06_resultmap;

import java.util.List;

public interface OrderDAO {
	
	public void insertMethod(OrderDTO dto);

	public List<OrderDTO> selectMethod();
	
}