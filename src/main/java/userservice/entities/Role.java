package userservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole role;


    public Role(){}
    public Role(ERole role){
        role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

}
