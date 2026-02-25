package co.com.wfnar.ias;

import co.com.wfnar.ias.gateway.OrderGateway;

public class OrderUseCase {

    private final OrderGateway orderGateway;

    public OrderUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public String createOrder(Order order){
        return orderGateway.saveOrder(order);
    }

    public String confirmOrder(Long id){
        Order order = orderGateway.getOrderById(id);
        order.confrim();
        return orderGateway.saveOrder(order);
    }

    public String cancelOrder(Long id){
        Order order = orderGateway.getOrderById(id);
        order.cancel();
        return orderGateway.saveOrder(order);
    }

    public Order getOrderById(Long id){
        return orderGateway.getOrderById(id);
    }

}
