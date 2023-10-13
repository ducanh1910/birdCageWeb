package service.impl;

import model.*;
import repository.CustomerRepository;
import repository.OrderDetailRepository;
import repository.OrderTableRepository;
import service.OrderTableService;
import service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderTableServiceImpl implements OrderTableService {
    private final OrderTableRepository orderRepository;
    private final OrderDetailRepository detailRepository;
    private final CustomerRepository customerRepository;
    private final ShoppingCartService cartService;

    @Override
    public OrderTable save(ShoppingCart shoppingCart) {
        OrderTable orderTable = new OrderTable();
        orderTable.setOrderDate(new Date());
        orderTable.setCustomer(shoppingCart.getCustomer());
        orderTable.setTax(2);
        orderTable.setTotalPrice(shoppingCart.getTotalPrice());
        orderTable.setAccept(false);
        orderTable.setPaymentMethod("Cash");
        orderTable.setOrderStatus("Pending");
        orderTable.setQuantity(shoppingCart.getTotalItems());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartItem item : shoppingCart.getCartItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderTable(orderTable);
            orderDetail.setProduct(item.getProduct());
            detailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
        }
        orderTable.setOrderDetailList(orderDetailList);
        cartService.deleteCartById(shoppingCart.getId());
        return orderRepository.save(orderTable);
    }

    @Override
    public List<OrderTable> findAll(String username) {
        Customer customer = customerRepository.findByUserName(username);
        List<OrderTable> orders = customer.getOrderTables();
        return orders;
    }

    @Override
    public List<OrderTable> findALlOrders() {
        return orderRepository.findAll();
    }


    @Override
    public OrderTable acceptOrder(Long id) {
        OrderTable orderTable = orderRepository.getById(id);
        orderTable.setAccept(true);
        orderTable.setDeliveryDate(new Date());
        return orderRepository.save(orderTable);
    }

    @Override
    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
