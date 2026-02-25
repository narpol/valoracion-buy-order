package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.OrderDBO;
import co.com.wfnar.ias.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryAdapter implements OrderGateway {

    private final IOrderRepository orderRepository;

    @Override
    public String createOrder(Order order) {

        orderRepository.save(OrderDBO.fromDomain(order));

        return "The Order was created";
    }

    @Override
    public String confirmOrder(Order order) {
        return "";
    }

    @Override
    public String cancelOrder(Long id) {
        return "";
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }
}
