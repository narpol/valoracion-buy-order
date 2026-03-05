package co.com.wfnar.ias.DBO;

import co.com.wfnar.ias.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Role role;

    public static UserDBO fromDomain(User user){
        UserDBO userDBO = new UserDBO(
                user.getId(),
                user.getName(),
                user.getRole()
        );
        return userDBO;
    }

    public static User toDomain(UserDBO userDBO){
        return switch ( userDBO.role){
            case ADMIN -> new Administrador(userDBO.getId(),userDBO.getName());
            case EMPLOYEE -> new Employee(userDBO.getId(),userDBO.getName());
            case CUSTOMER -> new Customer(userDBO.getId(),userDBO.getName());
        };
    }
}
