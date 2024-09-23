package OrderDAO;

import Order.Order;

public interface OrderDAO {
    int insertOrder(Order o);
    Order fetchOnOrderId(int order_id);
    int updateOrder(int order_id, String status);
}
