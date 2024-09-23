package Menu;

public class Menu {
	private int Menu_id;
	private int restaurant_id;
	private String item_name;
	private String Description;
	private float price;
	private boolean isActive;
	private String imgpath;
	
	
	
	public Menu() {
		super();
	}



	public Menu(int menu_id, int restaurant_id, String item_name, String description, float price, boolean isActive,
			String imgpath) {
		super();
		Menu_id = menu_id;
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		Description = description;
		this.price = price;
		this.isActive = isActive;
		this.imgpath = imgpath;
	}



	public Menu(int restaurant_id, String item_name, String description, float price, boolean isActive,
			String imgpath) {
		super();
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		Description = description;
		this.price = price;
		this.isActive = isActive;
		this.imgpath = imgpath;
	}



	public int getMenu_id() {
		return Menu_id;
	}



	public void setMenu_id(int menu_id) {
		Menu_id = menu_id;
	}



	public int getRestaurant_id() {
		return restaurant_id;
	}



	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}



	public String getItem_name() {
		return item_name;
	}



	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public String getImgpath() {
		return imgpath;
	}



	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}



	@Override
	public String toString() {
		return  Menu_id + " " + restaurant_id + " " + item_name
				+ " " + Description + " " + price + " " + isActive + " "
				+ imgpath;
	}
	
	
	
	
	
	
	

}
