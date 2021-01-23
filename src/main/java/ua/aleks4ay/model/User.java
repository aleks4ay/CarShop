package ua.aleks4ay.model;

import java.util.*;

public class User {

//    private int id;
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private boolean enabled = true;

    private Date registered = new Date();
    private Set<Role> roles;
    private List<Order> orders;

    public User() {
    }





    public void setRoles(Collection<Role> roles) {
        this.roles = roles.isEmpty() ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

}