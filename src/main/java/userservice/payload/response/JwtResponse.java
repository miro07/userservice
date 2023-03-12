package userservice.payload.response;

import java.time.LocalDateTime;
import java.util.Set;

public class JwtResponse {




    private String token;

    private String type = "Bearer";

    private Long id;

    private String userName;

    private String email;

    private Set<String> roles;


    private int Expiration;

    private LocalDateTime issuedAt;

    public JwtResponse(String token, LocalDateTime issuedAt, int expiration, Long id, String userName, String email, Set<String> roles) {
        this.token = token;
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.roles = roles;
        this.Expiration = expiration;
        this.issuedAt = issuedAt;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    public int getExpiration() {
        return Expiration;
    }

    public void setExpiration(int expiration) {
        Expiration = expiration;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

}
