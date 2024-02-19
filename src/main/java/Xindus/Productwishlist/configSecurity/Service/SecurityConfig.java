package Xindus.Productwishlist.configSecurity.Service;

import Xindus.Productwishlist.Entity.UserEntity;
import Xindus.Productwishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {


        return httpSecurity.csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())  // basic login option
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/user/login", "/user/register").permitAll()
                        .requestMatchers("/product/**", "/user/**").authenticated()


                        .anyRequest().authenticated()) // any request authenticate
                .userDetailsService(getUserDetailsService()).build();
    }


//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/public/**")
//                .permitAll()
//                .requestMatchers("/public/add/**")
//                .permitAll()
//                .requestMatchers("/student/add/**")
//                .permitAll()
//                .requestMatchers("/student/welcome")
//                .hasAnyRole("STUDENT", "ADMIN")
//                .requestMatchers("/admin/add/**")
//                .permitAll()
//                .requestMatchers("/admin/welcome")
//                .hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//        return httpSecurity.build();


    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return daoAuthenticationProvider;
    }
}