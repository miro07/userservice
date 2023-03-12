package userservice.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import userservice.dao.UserDao;
import userservice.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDoa;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        User user = userDoa.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: + username"));

        return UserDetailsImpl.build(user);
    }
}
