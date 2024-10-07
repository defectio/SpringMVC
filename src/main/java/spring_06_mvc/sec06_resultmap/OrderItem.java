package spring_06_mvc.sec06_resultmap;

/**
 * form에서 입력한 값이 여기에 추가 되고 OrderDTO에 list로 저장됨.
 * @author USER
 */
public class OrderItem {
	
	private String id;
	private int cnt;
	private String remark;
	
	public OrderItem() {}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getCnt() {
		return cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

}