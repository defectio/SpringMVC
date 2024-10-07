package spring_06_mvc.sec06_resultmap;

import java.util.List;

public class OrderDTO {
	
	private List<OrderItem> list;  //OrderItem의 id, cnt, remark에 저장된게 list로 들어옴
	private String address;
	
	public OrderDTO() {}
	
	public List<OrderItem> getList() {
		return list;
	}
	public void setList(List<OrderItem> list) {
		this.list = list;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}