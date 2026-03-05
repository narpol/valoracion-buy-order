package co.com.wfnar.ias;

public abstract class User {
    protected Long id;
    protected String name;
    protected Role role;

    public User(Long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public abstract boolean canCreateOrder();

}
