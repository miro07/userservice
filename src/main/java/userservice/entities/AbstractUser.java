package userservice.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@MappedSuperclass
public abstract class AbstractUser {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;
    @Column
    protected String firstName;

    @Column
    protected String lastName;

    @Embedded
    protected Address address;

    @Column
    protected String phone;

    @Column
    @NotBlank
    @Size(max = 50)
    @Email
    protected String email;

    @Column
    @NotBlank
    @Size(max = 20)
    protected String userName;

    @Column
    @NotBlank
    @Size(max = 120)
    protected String password;

    protected AbstractUser(){};
    public Long getUserId() {return userId;}

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserId(Long userId) {this.userId = userId;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
