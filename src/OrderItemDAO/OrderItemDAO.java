package OrderItemDAO;

import OrderItem.OrderItem;

public interface OrderItemDAO {
    int insertOrderItem(OrderItem oi);
    OrderItem fetchOrderById(int order_id);
}
