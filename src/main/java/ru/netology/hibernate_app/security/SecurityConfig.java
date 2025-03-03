package ru.netology.hibernate_app.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends  WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
       auth
               .inMemoryAuthentication()
               .withUser("Andrew")
               .password(passwordEncoder().encode("qwerty"))
               .roles("READ")
               .and()
               .withUser("John")
               .password(passwordEncoder().encode("12345"))
               .roles("WRITE")
               .and()
               .withUser("Mary")
               .password(passwordEncoder().encode("q1w2e3"))
               .roles("DELETE")
               .and()
               .withUser("admin")
               .password(passwordEncoder().encode("admin"))
               .roles("READ", "WRITE", "DELETE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated() // все остальные требуют аутентификацию
                .and().formLogin(); // стандартная форма логина
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
