package userDAO;

import java.util.List;

import user.User;

public interface UserDAO {
	int insertUser(User user);
	List <User>getAllUser();
	User  getUserByEmail(String email);
	int deleteUserById(int id);
	int UpdateUserById(int id,String address );
}
