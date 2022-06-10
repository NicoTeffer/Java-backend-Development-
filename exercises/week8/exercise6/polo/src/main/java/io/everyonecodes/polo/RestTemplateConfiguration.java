package io.everyonecodes.polo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("marco-polo")
public class RestTemplateConfiguration {

    private List<PoloUser> marcoPoloUsers;

    public void setMarcoPoloUsers(List<PoloUser> marcoPoloUsers) {
        this.marcoPoloUsers = marcoPoloUsers;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        List<UserDetails> users = marcoPoloUsers.stream()
                .map(toUserDetails(passwordEncoder))
                .collect(Collectors.toList());
        return new InMemoryUserDetailsManager(users);
    }

    private Function<PoloUser, UserDetails> toUserDetails(PasswordEncoder passwordEncoder) {
        return languageSchoolUser -> User.withUsername(languageSchoolUser.getUsername())
                .password(passwordEncoder().encode(languageSchoolUser.getPassword()))
                .authorities(languageSchoolUser.getAuthorities())
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/polo").permitAll()  //TODO: <-- What is this doing again, exactly!?
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
