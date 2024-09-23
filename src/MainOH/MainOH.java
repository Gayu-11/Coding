package MainOH;

import OrderHistory.OrderHistory;
import OrderHistoryDAO.OrderHistoryDAO;
import OrderHistoryDAOimpl.OrderHistoryDAOimpl;

import java.sql.Timestamp;

public class MainOH {
    public static void main(String[] args) {
        
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOimpl();
//        System.out.println("Inserting new order history...");
//        OrderHistory newOrderHistory = new OrderHistory(
//                1, 
//                1,
//                299.99f, 
//                "Completed" 
//        );
//        int insertStatus = orderHistoryDAO.insertOrderHistory(newOrderHistory);
//        System.out.println(insertStatus + " row(s) inserted.");

        
        
//        OrderHistory fetchedOrder = orderHistoryDAO.fetchOrderByOrderId(1);
//        if (fetchedOrder != null) {
//            System.out.println("Order History: " + fetchedOrder);
//        } else {
//            System.out.println("Order not found.");
//        }
//
//        
        int updateStatus = orderHistoryDAO.updateOrderHistory(1, "Shipped");
        System.out.println(updateStatus + " row(s) updated.");
//
//        
        
    }
}
