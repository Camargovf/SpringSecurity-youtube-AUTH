package authentication.authentication.security;

import authentication.authentication.modules.user.UserRepository;
import authentication.authentication.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existUser = userRepository.findByUsername(username);

        if (existUser != null) {
            throw new UsernameNotFoundException("User already exists!");
        }

        return UserPrincipal.create(existUser);
    }
}