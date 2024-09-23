package OrderDAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Order.Order;
import OrderDAO.OrderDAO;

public class OrderDAOimpl implements OrderDAO {

    static Connection con;
    static PreparedStatement pstmt;
    private static final String INSERT_ORDER = "INSERT INTO `order` (user_id, restaurant_id, status, totalAmount, paymentoption) VALUES (?,?,?,?,?)";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM `order` WHERE order_id=?";
    private static final String UPDATE_ORDER_STATUS = "UPDATE `order` SET status=? WHERE order_id=?";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery", "root", "Gayathri@07");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrder(Order o) {
        int result = 0;
        try {
            pstmt = con.prepareStatement(INSERT_ORDER);
            pstmt.setInt(1, o.getUser_id());
            pstmt.setInt(2, o.getRestaurant_id());
            pstmt.setString(3, o.getStatus());
            pstmt.setFloat(4, o.getTotalAmount());
            pstmt.setString(5, o.getPaymentoption());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Order fetchOnOrderId(int order_id) {
        Order order = null;
        try {
            pstmt = con.prepareStatement(GET_ORDER_BY_ID);
            pstmt.setInt(1, order_id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                order = new Order(
                    rs.getInt("order_id"),
                    rs.getInt("user_id"),
                    rs.getInt("restaurant_id"),
                    rs.getString("status"),
                    rs.getFloat("totalAmount"),
                    rs.getString("paymentoption")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int updateOrder(int order_id, String status) {
        int result = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_ORDER_STATUS);
            pstmt.setString(1, status);
            pstmt.setInt(2, order_id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
