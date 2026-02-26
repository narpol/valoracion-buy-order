package co.com.wfnar.ias.config;

import co.com.wfnar.ias.IH2OrderRepository;
import co.com.wfnar.ias.H2OrderRepositoryAdapter;
import co.com.wfnar.ias.gateway.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("h2")
@Configuration
public class H2AdapterConfig {

    @Bean
    public OrderRepository orderRepository(IH2OrderRepository orderRepository) {
        return new H2OrderRepositoryAdapter(orderRepository);
    }


}
