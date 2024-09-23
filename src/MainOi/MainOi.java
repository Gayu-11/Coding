package MainOi;

import OrderItem.OrderItem;
import OrderItemDAO.OrderItemDAO;
import OrderItemDAOimpl.OrderItemDAOimpl;

public class MainOi {
    public static void main(String[] args) {
        OrderItemDAO orderItemDAO = new OrderItemDAOimpl();

        // Insert a new order item
//        OrderItem newOrderItem = new OrderItem(1, 2, 2, 200);
//        int insertStatus = orderItemDAO.insertOrderItem(newOrderItem);
//        System.out.println(insertStatus + " row(s) inserted.");

//         Fetch an order item by Order_id
        OrderItem fetchedOrderItem = orderItemDAO.fetchOrderById(1);
        if (fetchedOrderItem != null) {
            System.out.println(fetchedOrderItem);
        } else {
            System.out.println("Order item not found.");
        }
    }
}
