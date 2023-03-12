package userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import userservice.entities.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("select u.id from User u where u.userName LIKE :x")
    public Long userIdByUsername(@Param("x")String username);

    public Optional<User> findByUserName(String username);
    public Boolean existsByUserName(String username);
    public Boolean existsByEmail(String email);
}
