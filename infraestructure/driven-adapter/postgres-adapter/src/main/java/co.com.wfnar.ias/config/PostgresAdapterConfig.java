package co.com.wfnar.ias.config;

import co.com.wfnar.ias.IOrderRepository;
import co.com.wfnar.ias.OrderRepositoryAdapter;
import co.com.wfnar.ias.gateway.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresAdapterConfig {

/*    @Bean
    public OrderRepository orderRepository(IOrderRepository orderRepository) {
        return new OrderRepositoryAdapter(orderRepository);
    }*/
}
