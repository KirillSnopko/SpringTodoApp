package com.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("kira").password("{noop}1234").roles("USER");
    }
*/
    @Autowired
    private DataSource dataSource;

     @Autowired
     public void configGlobal(AuthenticationManagerBuilder auth)throws Exception {
         auth.jdbcAuthentication().dataSource(dataSource);
             //    .usersByUsernameQuery("")
             //    .authoritiesByUsernameQuery("");

     }

    /*
     usernameParameter("login") вместо дефолтного значение "username"
     loginProcessingUrl("/login") - form action="/login" если по дефолту, можно не указывать
     logoutUrl("logout") - form action="/logout" если по дефолту, можно не указывать
     logoutSuccessUrl("/") - куда попадаем после выхода
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/*").hasRole("USER")
                .antMatchers("/admin/*").hasAnyRole("ADMIN")
                .antMatchers("/").permitAll()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .and()
                .logout()
                .logoutUrl("logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }
}
