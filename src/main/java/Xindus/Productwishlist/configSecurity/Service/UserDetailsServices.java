package Xindus.Productwishlist.configSecurity.Service;


import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class UserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // once the user enter credentials this method will invoke and check weather the user presents or not
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).get();

        if (user == null)
            throw new UsernameNotFoundException("user not found exception");

        return new UserDetailsCreator(user);
    }
}

