package userservice.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USERS",uniqueConstraints = {
        @UniqueConstraint(columnNames = "userName"),
        @UniqueConstraint(columnNames = "email")
      })
public class User extends AbstractUser implements Serializable {



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLES",
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> userRoles = new HashSet<>();

    public User(){}
    public User(String username, String email,String password, String firstName, String lastName
                , String phone, Address address){
        this.userName = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }

}
