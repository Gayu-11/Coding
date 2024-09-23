package OrderHistory;



public class OrderHistory {
    private int OH_id;
    private int user_id;
    private int order_id;
   
    private float total;
    private String status;

    // Constructors, getters, setters, and toString methods
    public OrderHistory() {}

    public OrderHistory(int user_id, int order_id,  float total, String status) {
        this.user_id = user_id;
        this.order_id = order_id;
     
        this.total = total;
        this.status = status;
    }

    

	// Getters and setters...

    public int getOH_id() {
		return OH_id;
	}

	public void setOH_id(int oH_id) {
		OH_id = oH_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return  OH_id + " " + user_id + " " + order_id + 
                " "  + total + " " + status ;
    }
}
