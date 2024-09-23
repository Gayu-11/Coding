package MenuDAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Menu.Menu;
import MenuDAO.MenuDAO;

public class MenuDAOimpl implements MenuDAO {
    static Connection con;
    int x = -1;
    Menu menu;
    static ArrayList<Menu> menuList = new ArrayList<>();

    private PreparedStatement pstmt;
    private static Statement stmt;
    private static ResultSet res;
    
    private static final String INSERT_MENU = "insert into menu(restaurant_id, item_name, Description, price, isActive, imgpath) values(?,?,?,?,?,?)";
    private static final String GET_ALL_MENU = "Select * from menu where restaurant_id = ?";
    private static final String GET_MENU_BY_ID = "Select * from menu where Menu_id = ?";
    private static final String DELETE_MENU_ID = "delete from menu where Menu_id = ?";
    private static final String UPDATE_BY_ID = "update menu set isActive = ? where Menu_id = ?";

    // Database connection setup
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery", "root", "Gayathri@07");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertMenu(Menu menu) {
        try {
            pstmt = con.prepareStatement(INSERT_MENU);
            pstmt.setInt(1, menu.getRestaurant_id());
            pstmt.setString(2, menu.getItem_name());
            pstmt.setString(3, menu.getDescription());
            pstmt.setFloat(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isActive());
            pstmt.setString(6, menu.getImgpath());

            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, null);
        }
        return x;
    }

    @Override
    public List<Menu> getAllMenu(int restaurant_id) {
        List<Menu> menuList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(GET_ALL_MENU);
            pstmt.setInt(1, restaurant_id);
            res = pstmt.executeQuery();
            menuList = extractMenuListFromResultSet(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, res);
        }

        return menuList;
    }

    private List<Menu> extractMenuListFromResultSet(ResultSet res) {
        List<Menu> menuList = new ArrayList<>();
        try {
            while (res.next()) {
                Menu menu = new Menu(
                    res.getInt("Menu_id"),
                    res.getInt("restaurant_id"),
                    res.getString("item_name"),
                    res.getString("Description"),
                    res.getFloat("price"),
                    res.getBoolean("isActive"),
                    res.getString("imgpath")
                );
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu getMenuById(int Menu_id) {
        Menu menu = null;
        try {
            pstmt = con.prepareStatement(GET_MENU_BY_ID);
            pstmt.setInt(1, Menu_id);
            res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu(
                    res.getInt("Menu_id"),
                    res.getInt("restaurant_id"),
                    res.getString("item_name"),
                    res.getString("Description"),
                    res.getFloat("price"),
                    res.getBoolean("isActive"),
                    res.getString("imgpath")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, res);
        }
        return menu;
    }

    @Override
    public int deleteMenuById(int Menu_id) {
        try {
            pstmt = con.prepareStatement(DELETE_MENU_ID);
            pstmt.setInt(1, Menu_id);
            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, null);
        }
        return x;
    }

    @Override
    public int updateMenuById(int Menu_id, boolean isActive) {
        try {
            pstmt = con.prepareStatement(UPDATE_BY_ID);
            pstmt.setBoolean(1, isActive);
            pstmt.setInt(2, Menu_id);
            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, null);
        }
        return x;
    }

    private void closeResources(PreparedStatement pstmt, ResultSet res) {
        try {
            if (res != null) res.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
