package userDAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.User;
import userDAO.UserDAO;

public class UserDAOimpl implements UserDAO{
	static Connection con;
	int x=-1;
	User user;
	static ArrayList<User> userList=new ArrayList();
	private PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet res;
	private static  final String INSERT_USER="insert into user(username, password, email, address, role) values(?,?,?,?,?)";
	private static final String GET_ALL_USER="Select * from  user";
	private static final String GET_USER_by_ID="Select * from  user where email=?";
	private static final String DELETE_USER_ID="delete from user where user_id=?";
	private static final String UPDATE_ADDRESS_BY_ID="update user set address=? where user_id=?";
	
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
	public int insertUser(User u) {
		
		
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(INSERT_USER);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getRole());
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
 
	@Override
	 public List<User> getAllUser() {
	try {
		stmt=con.createStatement();
		 res=stmt.executeQuery(GET_ALL_USER);
		userList=(ArrayList<User>) extractUserListFromResultSet(res);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			pstmt=con.prepareStatement(GET_USER_by_ID);
			pstmt.setString(1, email);
			res=pstmt.executeQuery();
			userList=(ArrayList<User>) extractUserListFromResultSet(res);
			user=userList.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUserById(int id) {
		try {
			pstmt=con.prepareStatement(DELETE_USER_ID);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
		
	}
	 List<User> extractUserListFromResultSet(ResultSet res)
	{
		
		 try {
			 while(res.next())
				{
			userList.add(new User(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return userList; 
	}

	@Override
	public int UpdateUserById(int id, String address) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(UPDATE_ADDRESS_BY_ID);
			pstmt.setInt(2, id);
			pstmt.setString(1, address);
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	
}