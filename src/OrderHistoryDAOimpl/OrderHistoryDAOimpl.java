package OrderHistoryDAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import OrderHistory.OrderHistory;
import OrderHistoryDAO.OrderHistoryDAO;
import java.sql.DriverManager;

public class OrderHistoryDAOimpl implements OrderHistoryDAO {
    static Connection con;
    private PreparedStatement pstmt;
    private ResultSet res;
    private static final String INSERT_ORDER_HISTORY = "INSERT INTO orderhistory(user_id, Order_id, total, status) VALUES (?, ?, ?, ?)";
    private static final String FETCH_ORDER_BY_ORDER_ID = "SELECT * FROM orderhistory WHERE Order_id = ?";
    private static final String UPDATE_ORDER_HISTORY = "UPDATE orderhistory SET status = ? WHERE Order_id = ?";

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
    public OrderHistory fetchOrderByOrderId(int order_id) {
        OrderHistory orderHistory = null;
        try {
            pstmt = con.prepareStatement(FETCH_ORDER_BY_ORDER_ID);
            pstmt.setInt(1, order_id);
            res = pstmt.executeQuery();
            
            if (res.next()) {
                orderHistory = new OrderHistory(
                    res.getInt("user_id"),
                    res.getInt("Order_id"),
                   
                    res.getFloat("total"),
                    res.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, res);
        }
        return orderHistory;
    }

    @Override
    public int insertOrderHistory(OrderHistory oh) {
        int result = 0;
        try {
            pstmt = con.prepareStatement(INSERT_ORDER_HISTORY);
            pstmt.setInt(1, oh.getUser_id());
            pstmt.setInt(2, oh.getOrder_id());
            
            pstmt.setFloat(3, oh.getTotal());
            pstmt.setString(4, oh.getStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, null);
        }
        return result;
    }

    @Override
    public int updateOrderHistory(int order_id, String status) {
        int result = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_ORDER_HISTORY);
            pstmt.setString(1, status);
            pstmt.setInt(2, order_id);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, null);
        }
        return result;
    }

    // Method to close PreparedStatement and ResultSet
    private void closeResources(PreparedStatement pstmt, ResultSet res) {
        try {
            if (res != null) res.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
