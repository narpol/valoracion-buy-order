package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.OrderDBO;
import co.com.wfnar.ias.gateway.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final IOrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        OrderDBO orderDBO = orderRepository.save(OrderDBO.fromDomain(order));
        return OrderDBO.toDomain(orderDBO);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(OrderDBO::toDomain)
                .orElseThrow( () -> new RuntimeException("Order Not Found"));
    }
}
