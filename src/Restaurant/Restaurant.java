package Restaurant;

public class Restaurant {
	private int Restaurant_id;
	private String name;
	private String cuisiveType;
	private int DeliveryTime;
	private boolean isActive;
	private int Rating;
	private String imgpath;
	
	
	
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurant_id, String name, String cuisiveType, int deliveryTime, boolean isActive,
			int rating, String imgpath) {
		super();
		Restaurant_id = restaurant_id;
		this.name = name;
		this.cuisiveType = cuisiveType;
		DeliveryTime = deliveryTime;
		this.isActive = isActive;
		Rating = rating;
		this.imgpath = imgpath;
	}
	public Restaurant(String name, String cuisiveType, int deliveryTime, boolean isActive, int rating, String imgpath) {
		super();
		this.name = name;
		this.cuisiveType = cuisiveType;
		DeliveryTime = deliveryTime;
		this.isActive = isActive;
		Rating = rating;
		this.imgpath = imgpath;
	}
	public int getRestaurant_id() {
		return Restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		Restaurant_id = restaurant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisiveType() {
		return cuisiveType;
	}
	public void setCuisiveType(String cuisiveType) {
		this.cuisiveType = cuisiveType;
	}
	public int getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return Restaurant_id + " " + name + " " + cuisiveType
				+ " " + DeliveryTime + " " + isActive + " " + Rating + " "
				+ imgpath ;
	}
	
	

}
