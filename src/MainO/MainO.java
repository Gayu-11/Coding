package MainO;

import Order.Order;
import OrderDAO.OrderDAO;
import OrderDAOimpl.OrderDAOimpl;

public class MainO{
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAOimpl();

        // Insert a new order
//        Order newOrder = new Order(1, 104, "Pending", 500.50f, "Credit Card");
//        int insertStatus = orderDAO.insertOrder(newOrder);
//        System.out.println(insertStatus + " row(s) inserted.");

         //Fetch an order by order_id
//        Order fetchedOrder = orderDAO.fetchOnOrderId(1);
//        if (fetchedOrder != null) {
//            System.out.println( fetchedOrder);
//        } else {
//            System.out.println("Order not found.");
//        }
//
        // Update order status
        int updateStatus = orderDAO.updateOrder(1, "Shipped");
        System.out.println(updateStatus + " row(s) updated.");
    }
}
