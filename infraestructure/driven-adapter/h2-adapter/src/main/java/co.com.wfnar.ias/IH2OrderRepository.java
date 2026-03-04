package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.H2OrderDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IH2OrderRepository extends JpaRepository<H2OrderDBO, Long> {

}
