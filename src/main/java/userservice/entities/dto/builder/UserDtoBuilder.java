package userservice.entities.dto.builder;

import userservice.entities.Address;
import userservice.entities.User;
import userservice.entities.dto.PostDto;
import userservice.entities.dto.UserDto;

import java.util.List;

public class UserDtoBuilder {

    UserDto userDto;

    public UserDtoBuilder(){
        userDto= new UserDto();
    }
    public UserDtoBuilder withUserId(Long userId){
        userDto.setUserId(userId);
        return this;
    }

    public UserDtoBuilder withUsername(String username){
        userDto.setUserName(username);
        return this;
    }
    public UserDtoBuilder withFirstname(String firstname){
        userDto.setFirstName(firstname);
        return this;
    }
    public UserDtoBuilder withLastname(String lastname){
        userDto.setLastName(lastname);
        return this;
    }
    public UserDtoBuilder withAddress(Address address){
        userDto.setAddress(address.toString());
        return this;
    }
    public UserDtoBuilder withPhone(String phone){
        userDto.setPhone(phone);
        return this;
    }
    public UserDtoBuilder withEmail(String email){
        userDto.setEmail(email);
        return this;
    }
    public UserDtoBuilder withPosts(List<PostDto> posts){
        userDto.setPosts(posts);
        return this;
    }

    public UserDto build() {
        return userDto;
    }

    public static UserDto responseBuildUserDto(User user,List<PostDto> posts) {
        return new UserDtoBuilder()
                .withUserId(user.getUserId())
                .withUsername(user.getUserName())
                .withFirstname(user.getFirstName())
                .withLastname(user.getLastName())
                .withPhone(user.getPhone())
                .withEmail(user.getEmail())
                .withAddress(user.getAddress())
                .withPosts(posts)
                .build();
    }
    public static UserDto responseBuildUserDto(User user) {
        return new UserDtoBuilder()
                .withUserId(user.getUserId())
                .withUsername(user.getUserName())
                .withFirstname(user.getFirstName())
                .withLastname(user.getLastName())
                .withPhone(user.getPhone())
                .withEmail(user.getEmail())
                .withAddress(user.getAddress())

                .build();
    }
}
