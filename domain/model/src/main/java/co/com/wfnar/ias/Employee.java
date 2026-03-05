package co.com.wfnar.ias;

public class Employee extends User{

    public Employee(Long id, String name) {
        super(id, name, Role.EMPLOYEE);
    }

    @Override
    public boolean canCreateOrder() {
        return true;
    }
}
