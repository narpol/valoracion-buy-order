package co.com.wfnar.ias.config;

import co.com.wfnar.ias.OrderUseCase;
import co.com.wfnar.ias.gateway.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public OrderUseCase orderUseCase(OrderRepository orderRepository){
        return new OrderUseCase(orderRepository);
    }


}
