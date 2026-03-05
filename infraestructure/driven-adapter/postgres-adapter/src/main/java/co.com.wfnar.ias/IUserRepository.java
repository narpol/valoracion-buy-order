package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserDBO, Long> {
}
