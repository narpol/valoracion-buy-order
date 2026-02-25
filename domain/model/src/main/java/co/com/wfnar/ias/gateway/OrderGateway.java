package co.com.wfnar.ias.gateway;

import co.com.wfnar.ias.Order;

public interface OrderGateway {

    String saveOrder(Order order);
    Order getOrderById(Long id);

}
