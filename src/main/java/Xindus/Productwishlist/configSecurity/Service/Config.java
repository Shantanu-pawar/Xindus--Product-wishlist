//package Xindus.Productwishlist.configSecurity.Service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class Config {
//    @Autowired
//    private UserDetailsServices userDetailsService;
//
//    // security filter chain authorize the user
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // role based authentication only one user presents
//
//        return http.csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())  // basic login option
//                .authorizeHttpRequests(req -> req
//                        .requestMatchers("/user/login", "/user/register").permitAll()
//                        .requestMatchers("/product/**", "/user/**").authenticated()
//
//                        // we don't need this authorisation since only one user is present.
////                        .requestMatchers("/user/**").hasAnyAuthority("USER")
//
//                        .anyRequest().authenticated()) // any request authenticate
//                .userDetailsService(userDetailsService).build();
//    }
//
//    @Bean
//        // this bean is used to encode the password using BCryPasswordEncoder
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider getDaoAuthenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
//        return daoAuthenticationProvider;
//    }
//}
//
