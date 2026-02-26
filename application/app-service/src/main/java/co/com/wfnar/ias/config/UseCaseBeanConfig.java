package co.com.wfnar.ias.config;

import co.com.wfnar.ias.H2OrderRepositoryAdapter;
import co.com.wfnar.ias.OrderRepositoryAdapter;
import co.com.wfnar.ias.OrderUseCase;
import co.com.wfnar.ias.gateway.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

/*    @Bean
    public OrderUseCase orderUseCase(OrderRepository orderRepository){
        return new OrderUseCase(orderRepository);
    }*/

/*    @Bean
    public OrderUseCase H2OrderUseCase(H2OrderRepositoryAdapter h2OrderRepositoryAdapter){
        return new OrderUseCase(h2OrderRepositoryAdapter);
    }*/

    @Bean
    public OrderUseCase postgresOrderUseCase(OrderRepositoryAdapter orderRepositoryAdapter){
        return new OrderUseCase(orderRepositoryAdapter);
    }


}
