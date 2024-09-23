package RestaurantDAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Restaurant.Restaurant;
import RestaurantDAO.RestaurantDAO;
import user.User;

public class RestaurantDAOimpl implements RestaurantDAO {
	static Connection con;
	int x=-1;
	Restaurant rest;
	static ArrayList<Restaurant> restList=new ArrayList();

	private PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet res;
	private static  final String INSERT_REST="insert into restaurant(Restaurant_id,name, CuisiveType, DeliveryTime, isActive, Rating, imgpath) values(?,?,?,?,?,?,?)";
	private static final String GET_ALL_REST="Select * from restaurant ";
	private static final String GET_REST_by_ID="Select * from  restaurant where restaurant_id=?";
	private static final String DELETE_REST_ID="delete from restaurant where restaurant_id=?";
	private static final String UPDATE_BY_ID="update restaurant set isActive=? where restaurant_id=?";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","Gayathri@07");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int insertRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(INSERT_REST);
			pstmt.setInt(1, rest.getRestaurant_id());
			pstmt.setString(2,rest.getName());
			pstmt.setString(3, rest.getCuisiveType());
			pstmt.setInt(4, rest.getDeliveryTime());
			pstmt.setBoolean(5, rest.isActive());
			pstmt.setInt(6, rest.getRating());
			pstmt.setString(7, rest.getImgpath());
			 x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		try {
			stmt=con.createStatement();
			 res=stmt.executeQuery(GET_ALL_REST);
			restList=(ArrayList<Restaurant>) extractUserListFromResultSet(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return restList;
	}
	 List<Restaurant> extractUserListFromResultSet(ResultSet res)
		{
			
			 try {
				 while(res.next())
					{
				restList.add(new Restaurant(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getBoolean(5),res.getInt(6),res.getString(7)));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 return restList; 
		}

	@Override
	public Restaurant getRestById(int Restaurant_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(GET_REST_by_ID);
			pstmt.setInt(1, Restaurant_id);
			res=pstmt.executeQuery();
			restList=(ArrayList<Restaurant>) extractUserListFromResultSet(res);
			rest=restList.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public int deleteRestById(int Restaurant_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(DELETE_REST_ID);
			pstmt.setInt(1,Restaurant_id );
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateById( boolean isActive,int Restaurant_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(UPDATE_BY_ID);
			pstmt.setBoolean(1,isActive );
			pstmt.setInt(2, Restaurant_id);
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	

}
