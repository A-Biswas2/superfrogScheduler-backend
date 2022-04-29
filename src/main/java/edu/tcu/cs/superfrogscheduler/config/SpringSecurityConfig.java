package edu.tcu.cs.superfrogscheduler.config;

import edu.tcu.cs.superfrogscheduler.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private ClientService clientService;

    public SpringSecurityConfig(ClientService clientService){
        this.clientService = clientService;
    }

    @Autowired
    public void setClientService(ClientService clientService){
        this.clientService = clientService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(this.clientService);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/artifacts/**").permitAll()
                .antMatchers("/superfrogs/**").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users").authenticated()
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAnyAuthority("admin")
                .and().formLogin().loginProcessingUrl("/users/login");
        http.csrf().disable();

        http.headers().frameOptions().disable();
    }
}
