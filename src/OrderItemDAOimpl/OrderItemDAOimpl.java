package OrderItemDAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import OrderItem.OrderItem;
import OrderItemDAO.OrderItemDAO;

public class OrderItemDAOimpl implements OrderItemDAO {

    static Connection con;
    static PreparedStatement pstmt;
    private static final String INSERT_ORDER_ITEM = "INSERT INTO orderitem (Order_id, Menu_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM orderitem WHERE Order_id=?";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery", "root", "Gayathri@07");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrderItem(OrderItem oi) {
        int result = 0;
        try {
            pstmt = con.prepareStatement(INSERT_ORDER_ITEM);
            pstmt.setInt(1, oi.getOrder_id());
            pstmt.setInt(2, oi.getMenu_id());
            pstmt.setInt(3, oi.getQuantity());
            pstmt.setInt(4, oi.getSubtotal());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public OrderItem fetchOrderById(int order_id) {
        OrderItem orderItem = null;
        try {
            pstmt = con.prepareStatement(GET_ORDER_BY_ID);
            pstmt.setInt(1, order_id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                orderItem = new OrderItem(
                    rs.getInt("OI_id"),
                    rs.getInt("Order_id"),
                    rs.getInt("Menu_id"),
                    rs.getInt("quantity"),
                    rs.getInt("subtotal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }
}
