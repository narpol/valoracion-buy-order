package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.OrderDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderDBO, Long> {

}
