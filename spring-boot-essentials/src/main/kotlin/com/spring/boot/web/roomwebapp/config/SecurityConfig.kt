package com.spring.boot.web.roomwebapp.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.web.DefaultSecurityFilterChain

/**
 * In the previous version of WebSecurity, it was required to use a WebSecurityConfigureAdapter.
 * In this latest version, both http and auth configuration is rather added through dependency injection
 */
@Configuration
@EnableWebSecurity
class SecurityConfig {

    /**
     * Original code was modified thanks to
     * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter/
     * https://codejava.net/frameworks/spring-boot/spring-security-fix-deprecated-methods
     * https://stackoverflow.com/a/74611324/2184088
     *
     * http.authorizeRequests().antMatchers("/", "/api/\*").permitAll()
     *                 .anyRequest().authenticated()
     *                 .and()
     *                 .formLogin()
     *                 .loginPage("/login").permitAll()
     *                 .and()
     *                 .logout().permitAll();
     **/
    @Bean
    @Throws(Exception::class)
    fun configure(http: HttpSecurity): DefaultSecurityFilterChain? {
        return http.authorizeHttpRequests { authz ->
            authz.requestMatchers("/", "/api/*").permitAll().anyRequest().authenticated()
        }.formLogin { formLogin ->
            formLogin.loginPage("/login").permitAll()
        }.logout { logout ->
            logout.permitAll()
        }.build()
    }

    @Autowired
    @Throws(Exception::class)
    @Suppress("DEPRECATION")
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        // NoOpPasswordEncoder is applied for development purposes only, do not use this approach for production.
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("user").password("password").roles("USER")
    }
}