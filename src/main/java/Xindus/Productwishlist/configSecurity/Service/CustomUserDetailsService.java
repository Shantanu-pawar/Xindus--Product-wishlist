package Xindus.Productwishlist.configSecurity.Service;

import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).get();
        if(user==null){
            throw new UsernameNotFoundException("Invalid User");
        }
        return new UserDetailsCreator(user);
    }
}