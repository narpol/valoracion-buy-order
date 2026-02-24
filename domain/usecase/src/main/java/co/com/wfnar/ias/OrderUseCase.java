package co.com.wfnar.ias;

import co.com.wfnar.ias.gateway.OrderGateway;

public class OrderUseCase {

    private final OrderGateway orderGateway;

    public OrderUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public String createOrder(Order order){
        return orderGateway.createOrder(order);
    }

    public String confirmOrder(Order order){
        return orderGateway.confirmOrder(order);
    }

    public String cancelOrder(Long id){
        return orderGateway.cancelOrder(id);
    }

    public Order getOrderById(Long id){
        return orderGateway.getOrderById(id);
    }

}
