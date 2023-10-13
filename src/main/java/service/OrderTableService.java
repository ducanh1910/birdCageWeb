package service;

import model.OrderTable;
import model.ShoppingCart;

import java.util.List;

public interface OrderTableService {
    OrderTable save(ShoppingCart shoppingCart);

    List<OrderTable> findAll(String username);

    List<OrderTable> findALlOrders();

    OrderTable acceptOrder(Long id);

    void cancelOrder(Long id);
}
