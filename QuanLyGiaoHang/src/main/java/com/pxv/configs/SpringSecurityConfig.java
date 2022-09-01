/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxv.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pxv.configs.handlers.LoginSuccessHandler;
import com.pxv.configs.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.pxv.repository",
    "com.pxv.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");

        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
//        http.formLogin().successHandler(this.loginSuccessHandler);
//
////        http.logout().logoutSuccessUrl("/login");
//        http.logout().logoutSuccessHandler(this.logoutHandler);
//
//        http.exceptionHandling()
//                .accessDeniedPage("/login?accessDenied");
//
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/order/**")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//                .antMatchers("/register/shipper")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SHIPPER')")
//                .antMatchers("/shipper/**")
//                .access("hasAnyRole('ROLE_SHIPPER', 'ROLE_ADMIN')")
//                .antMatchers("/admin/**")
//                .access("hasRole( 'ROLE_ADMIN')");
//
        http.csrf().disable();
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
    
    @Bean
    public LogoutSuccessHandler logoutHandler(){
        return new LogoutHandler();
    }

}
