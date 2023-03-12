package userservice.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import userservice.dao.RoleDao;
import userservice.entities.Role;
import userservice.services.RoleService;

import java.util.List;


@RestController
@RequestMapping("/users/roles")
public class RoleController {

    private static Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleDao roleDao;
    @Autowired
    RoleService roleService;

    @PostMapping("")
    public Role addRole(@RequestBody Role role){
        log.info("save a role");
        return roleDao.save(role);
    }

    @GetMapping("/get-all")
    public List<Role> getAllRoles(){
        log.info("call get all roles");
        return roleDao.findAll();
    }
    @DeleteMapping("/by-id")
    public void deleteById(@Valid @RequestParam(name = "id") Long id){
        log.info("delete role by id");
        roleDao.deleteById(id);
    }
}
