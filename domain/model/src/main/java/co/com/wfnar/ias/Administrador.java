package co.com.wfnar.ias;

public class Administrador extends User{

    public Administrador(Long id, String name) {
        super(id, name, Role.ADMIN);
    }

    @Override
    public boolean canCreateOrder() {
        return false;
    }

    public boolean canCreateUsers() {
        return true;
    }

}
