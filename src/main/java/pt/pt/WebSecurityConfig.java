package pt.pt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

        @Autowired
        private UserDetailsService userDetailService;

       
        @Bean
        public SecurityFilterChain configure(HttpSecurity http)
                        throws Exception {
                http.csrf().disable();
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/treenis").permitAll()
                                                .requestMatchers("/treenis/{id}").permitAll()
                                                .requestMatchers("/login").permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(formlogin -> formlogin
                                                .defaultSuccessUrl("/Etusivu", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .permitAll());
                return http.build();
        }
 @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
        }

}

