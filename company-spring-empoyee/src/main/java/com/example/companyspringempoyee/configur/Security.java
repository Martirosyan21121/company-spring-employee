package com.example.companyspringempoyee.configur;

import com.example.companyspringempoyee.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class Security extends WebSecurityConfigurerAdapter {
    private final SecurityService securityService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("index").permitAll()
                .antMatchers(HttpMethod.GET, "/addEmployee")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/employee")
                .hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/company")
                .hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/addCompany")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "//deleteCompany/**")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/addComment")
                .hasAnyAuthority("USER")
                .and()
                .csrf()
                .disable()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .formLogin();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService)
                .passwordEncoder(passwordEncoder);

    }
}
