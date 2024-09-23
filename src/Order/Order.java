package Order;

public class Order {
	private int Order_id;
	private int user_id;
	private int restaurant_id;
	private String status;
	private float totalAmount;
	private String paymentoption;
	
	
	public Order() {
		super();
	}


	public Order(int order_id, int user_id, int restaurant_id, String status, float totalAmount, String paymentoption) {
		super();
		Order_id = order_id;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.status = status;
		this.totalAmount = totalAmount;
		this.paymentoption = paymentoption;
	}


	public Order(int user_id, int restaurant_id, String status, float totalAmount, String paymentoption) {
		super();
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.status = status;
		this.totalAmount = totalAmount;
		this.paymentoption = paymentoption;
	}


	public int getOrder_id() {
		return Order_id;
	}


	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getPaymentoption() {
		return paymentoption;
	}


	public void setPaymentoption(String paymentoption) {
		this.paymentoption = paymentoption;
	}


	@Override
	public String toString() {
		return  + Order_id + " " + user_id + " " + restaurant_id + " "
				+ status + " " + totalAmount + " " + paymentoption ;
	}
	
	
	

}
