package fr.valtech.meetup.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile(value = "!security-disabled")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MeetupUserAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers("/manage/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

}
