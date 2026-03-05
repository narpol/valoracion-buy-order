package co.com.wfnar.ias;

import co.com.wfnar.ias.gateway.UserRepository;

public class CreateUserUseCase {

    private UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User userAdmin, User newUser){
        if(!(userAdmin instanceof Administrador)){
            throw new RuntimeException("Only Administradors can create users");
        }
        userRepository.save(newUser);
    }
}
