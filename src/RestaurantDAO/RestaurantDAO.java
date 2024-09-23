package RestaurantDAO;

import java.util.List;

import Restaurant.Restaurant;



public interface RestaurantDAO {
	int insertRestaurant(Restaurant rest);
	List<Restaurant> getAllRestaurant();
	Restaurant getRestById(int Restaurant_id);
	int deleteRestById(int Restaurant_id);
	int updateById(boolean isActive,int Restaurant_id);
	
	

}
