package Main1;

import java.util.ArrayList;

import Restaurant.Restaurant;
import RestaurantDAO.RestaurantDAO;
import RestaurantDAOimpl.RestaurantDAOimpl;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Restaurant r=new Restaurant(103,"Rani mess","Indian",30,true,5,"E:\\test\\download.jpeg");
		RestaurantDAO rdao=new RestaurantDAOimpl();
		int status=rdao.insertRestaurant(r);
		System.out.println(status+" row affected");
		
		
		
//		ArrayList<Restaurant> users=(ArrayList) rdao.getAllRestaurant();
//		for(Restaurant u:users)
//		{
//			System.out.println(u);
//		}
		
		
//		Restaurant res=rdao.getRestById(104);
//		System.out.println(res);
		
		
//		int status=	rdao.deleteRestById(103);
//		System.out.println(status+" row affected");
		
		
//		int status=rdao.updateById(true, 102);
//		System.out.println(status+" row affected");
	}
	

}
