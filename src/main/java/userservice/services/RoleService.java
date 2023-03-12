package userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.dao.RoleDao;
import userservice.entities.ERole;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public void deleteByRole(String role){
        roleDao.deleteByRole(ERole.valueOf(role));
    }
}
