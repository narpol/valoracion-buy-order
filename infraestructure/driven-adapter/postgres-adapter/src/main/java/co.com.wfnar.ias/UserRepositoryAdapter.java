package co.com.wfnar.ias;

import co.com.wfnar.ias.DBO.UserDBO;
import co.com.wfnar.ias.gateway.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final IUserRepository userRepository;

    @Override
    public User save(User user) {
        UserDBO userDBO = userRepository.save(UserDBO.fromDomain(user));
        return UserDBO.toDomain(userDBO);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id)
                .map(UserDBO::toDomain)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }
}
