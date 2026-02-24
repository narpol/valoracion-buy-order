package co.com.wfnar.ias.gateway;

import co.com.wfnar.ias.Order;

public interface OrderGateway {

    String createOrder(Order order);
    String confirmOrder(Order order);
    String cancelOrder(Long id);
    Order getOrderById(Long id);

}
