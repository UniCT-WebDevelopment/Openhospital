package com.openhospital.ecommerce.config;

import com.openhospital.ecommerce.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Configuration
    public static class LoginSecurityConfiguration extends WebSecurityConfigurerAdapter {

        public LoginSecurityConfiguration() {
            super();
        }

        @Autowired
        UserDetailsServiceImpl userDetailsService;

        @Autowired
        CustomAuthenticationSuccessHandler authenticationSuccessHandler;

        @Autowired
        CustomAuthenticationFailureHandler authenticationFailureHandler;

        @Autowired
        CustomLogoutSuccessHandler customLogoutSuccessHandler;

        @Bean("authenticationManager")
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/**/user-area**", "/**/user-area/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                    .formLogin()
                    .usernameParameter("email")
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                    .loginPage("/")
                    .loginProcessingUrl("/rest/auth/login")
                    .permitAll()
                    .and()
                    .logout().logoutUrl("/rest/auth/logout")
                    .logoutSuccessHandler(customLogoutSuccessHandler)
                    .permitAll();

            //Necessary if you need H2 Console
            httpSecurity.headers().frameOptions().disable();
        }

        @Bean
        public static PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

    }

}
