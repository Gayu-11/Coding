package MenuDAO;

import java.util.List;

import Menu.Menu;

public interface MenuDAO {
	int insertMenu(Menu m);
	List<Menu> getAllMenu(int restaurant_id);
	Menu getMenuById(int Menu_id);
	int deleteMenuById(int Menu_id);
	int updateMenuById(int Menu_id,boolean isActive);

}
