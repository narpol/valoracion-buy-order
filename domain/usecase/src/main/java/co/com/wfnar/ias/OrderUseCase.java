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
        Order modifiOrder = confrim(order.getId());
        return orderGateway.saveOrder(order);
    }

    public String cancelOrder(Long id){
        Order order = orderGateway.getOrderById(id);
        Order modifiOrder = cancel(order.getId());
        return orderGateway.saveOrder(order);
    }

    public Order getOrderById(Long id){
        return orderGateway.getOrderById(id);
    }

    private Order confrim(Long id){
        Order order = orderGateway.getOrderById(id);
        if(order.getStatus() != Status.CREATED){
            throw new IllegalArgumentException("Order status is not CREATED");
        }
        order.setStatus(Status.CONFIRMED);

        return order;
    }

    private Order cancel(Long id){
        Order order = orderGateway.getOrderById(id);
        if(order.getStatus() != Status.CREATED){
            throw new IllegalArgumentException("Order status is not CREATED");
        }
        order.setStatus(Status.CANCELLED);

        return order;
    }

}
