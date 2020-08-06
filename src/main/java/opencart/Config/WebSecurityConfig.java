package opencart.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();

    }

}

//package opencart.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
////    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
//                withUser("kai").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
//                withUser("sena").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");
//
////    auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("sena").password("123456").roles("USER");
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Allow user with admin privilege access path /admin/**
//        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
//        // Allow user with admin or user privilege access path /user/**
//        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");
//        // When user login, with user role, but request to path requiring admin role, direct to /403
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//        // Login Form Configuration.
//        http.authorizeRequests().and().formLogin()//
//                .loginProcessingUrl("/j_spring_security_login")//
//                .loginPage("/login")//
//                .defaultSuccessUrl("/user")//
//                .failureUrl("/login?message=error")//
//                .usernameParameter("username")//
//                .passwordParameter("password")
//                //Logout Page Configuration.
//                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
//    }
//}
