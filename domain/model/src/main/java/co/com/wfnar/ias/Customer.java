package co.com.wfnar.ias;

public class Customer extends User{

    public Customer(Long id, String name) {
        super(id, name, Role.CUSTOMER);
    }

    @Override
    public boolean canCreateOrder() {
        return false;
    }
}
