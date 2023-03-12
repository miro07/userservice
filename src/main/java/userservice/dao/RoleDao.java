package userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userservice.entities.ERole;
import userservice.entities.Role;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(ERole role);

    void deleteByRole(ERole role);
}
