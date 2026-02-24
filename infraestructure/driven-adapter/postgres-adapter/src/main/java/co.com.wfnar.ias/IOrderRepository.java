package co.com.wfnar.ias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderRepositoryAdapter, Long> {

}
