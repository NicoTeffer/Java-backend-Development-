package io.everyonecodes.steam_purchases;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("steam")
public class SecurityConfiguration {

    private List<GameUser> steamUsers;

    public void setSteamUsers(List<GameUser> steamUsers) {
        this.steamUsers = steamUsers;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> users = steamUsers.stream()
                .map(ridesUser -> createUserDetails(encoder, ridesUser))
                .collect(toList());
        return new InMemoryUserDetailsManager(users);
    }

    private UserDetails createUserDetails(PasswordEncoder encoder, GameUser gameuser) {
        return User.withUsername(gameuser.getUsername())
                .password(encoder.encode(gameuser.getPassword()))
                .authorities((GrantedAuthority) gameuser.getAuthorities())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
