package co.com.wfnar.ias;

import co.com.wfnar.ias.gateway.OrderRepository;

public class OrderUseCase {

    private final OrderRepository orderRepository;

    public OrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return orderRepository.saveOrder(order);
    }

    public Order confirmOrder(Long id){
        Order order = orderRepository.getOrderById(id);
        order.confrim();
        return orderRepository.saveOrder(order);
    }

    public Order cancelOrder(Long id){
        Order order = orderRepository.getOrderById(id);
        order.cancel();
        return orderRepository.saveOrder(order);
    }

    public Order getOrderById(Long id){
        return orderRepository.getOrderById(id);
    }

}
