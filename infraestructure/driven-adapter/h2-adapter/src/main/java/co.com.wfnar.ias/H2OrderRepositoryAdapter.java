package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.H2OrderDBO;
import co.com.wfnar.ias.gateway.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("h2")
@RequiredArgsConstructor
@Repository
public class H2OrderRepositoryAdapter implements OrderRepository {

    private final IH2OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        H2OrderDBO orderDBO = orderRepository.save(H2OrderDBO.fromDomain(order));
        return H2OrderDBO.toDomain(orderDBO);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(H2OrderDBO::toDomain)
                .orElseThrow( () -> new RuntimeException("Order Not Found"));
    }
}
