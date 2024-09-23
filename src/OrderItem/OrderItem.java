package OrderItem;

public class OrderItem {
	private int OI_id;
	private int Order_id;
	private int Menu_id;
	private int quantity;
	private int subtotal;
	
	
	
	
	public OrderItem() {
		super();
	}
	public OrderItem(int order_id, int menu_id, int quantity, int subtotal) {
		super();
		Order_id = order_id;
		Menu_id = menu_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItem(int oI_id, int order_id, int menu_id, int quantity, int subtotal) {
		super();
		OI_id = oI_id;
		Order_id = order_id;
		Menu_id = menu_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public int getOI_id() {
		return OI_id;
	}
	public void setOI_id(int oI_id) {
		OI_id = oI_id;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public int getMenu_id() {
		return Menu_id;
	}
	public void setMenu_id(int menu_id) {
		Menu_id = menu_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return  OI_id + " " + Order_id + " " + Menu_id + " "
				+ quantity + " " + subtotal;
	}
}
