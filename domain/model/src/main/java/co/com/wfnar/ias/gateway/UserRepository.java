package co.com.wfnar.ias.gateway;

import co.com.wfnar.ias.User;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
}
