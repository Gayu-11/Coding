package OrderHistoryDAO;

import java.util.List;
import OrderHistory.OrderHistory;

public interface OrderHistoryDAO {
    OrderHistory fetchOrderByOrderId(int order_id);
    int insertOrderHistory(OrderHistory oh);
    int updateOrderHistory(int order_id, String status);
}
