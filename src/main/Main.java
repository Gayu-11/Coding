package main;

import java.util.ArrayList;

import user.User;
import userDAO.UserDAO;
import userDAOimpl.UserDAOimpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		User u=new User("Gayathri","gayu@123","gayu1@gmail.com","car street","Dev");
		UserDAO udao=new UserDAOimpl();
//		int status=udao.insertUser(u);
//		System.out.println(status);
		
		
//		ArrayList<User> users=(ArrayList) udao.getAllUser();
//		for(User u:users)
//		{
//			System.out.println(u);
//		}
		
		
		User user=udao.getUserByEmail("gayu@gmail.com");
		System.out.println(user);
		
//	int status=	udao.deleteUserById(11);
//	System.out.println(status+" row affected");
		
		
		
//		int status=udao.UpdateUserById(1, "BTM layout");
//		System.out.println(status+" row affected");

	}

}
