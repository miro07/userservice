package userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import userservice.dao.RoleDao;
import userservice.dao.UserDao;
import userservice.entities.User;
import userservice.entities.dto.PostDto;
import userservice.entities.dto.UserDto;
import userservice.entities.dto.builder.UserDtoBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static userservice.entities.dto.builder.UserDtoBuilder.responseBuildUserDto;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public UserDto getUserById(Long userId) {
        User user = userDao.findById(userId).get();
        UserDto userDto = responseBuildUserDto(user, getPostsByUser(userId));
        return userDto;
    }
    public Boolean existsByUserName(String userName){
        return userDao.existsByUserName(userName);
    }
    public Boolean existsByEmail(String email){
        return userDao.existsByEmail(email);
    }
    public UserDto save(User user) {
        if(user.getUserRoles() != null)user.getUserRoles().forEach(role -> roleDao.save(role));
        User savedUser = userDao.save(user);
        return UserDtoBuilder.responseBuildUserDto(savedUser) ;
    }

    public UserDto updateUserProfile(Long id, User user) {
        Optional<User> optionalUser = userDao.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            if (user.getFirstName() != null) {
                existingUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                existingUser.setLastName(user.getLastName());
            }
            if (user.getAddress() != null) {
                existingUser.setAddress((user.getAddress()));
            }
            return save(existingUser);
        }
        return null;
    }

    public List<PostDto> getPostsByUser(Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8084/posts/user/{userId}";
        ResponseEntity<List<PostDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PostDto>>() {},
                userId
        );
        return response.getBody();
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        return
                users.stream().map(user -> {
                    UserDto userDto = responseBuildUserDto(user, getPostsByUser(user.getUserId()));
                    return userDto;
                }).collect(Collectors.toList());
    }

    public PostDto addPost(PostDto postDto) {
        HttpEntity<PostDto> requestEntity = new HttpEntity<>(postDto);
        ResponseEntity<PostDto> postEntity = restTemplate.exchange(
                "http://localhost:8084/posts",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {}
        );
        return postEntity.getBody();
    }

}