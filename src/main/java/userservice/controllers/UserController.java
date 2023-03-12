package userservice.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.entities.User;
import userservice.entities.dto.PostDto;
import userservice.entities.dto.UserDto;
import userservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
     private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        log.info("call getUser of UserController");
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        log.info("call get all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PutMapping("edit/{id}")
    public ResponseEntity<UserDto> updateUserProfile(@PathVariable Long id, @Valid @RequestBody User user) {
        log.info("edit a user");
        UserDto updatedUser = userService.updateUserProfile(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    // Post's APIs
    @PostMapping("/posts")
    public ResponseEntity<PostDto> addPost(@Valid @RequestBody PostDto post){
        log.info("add a post");
        return ResponseEntity.ok(userService.addPost(post));
    }

}
