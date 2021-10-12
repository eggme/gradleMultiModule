package com.example.sampleauth.config

import com.example.sampleauth.security.CoreMemberDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired private lateinit var coreMemberDetailService: CoreMemberDetailService

    fun expressionHandler(): DefaultWebSecurityExpressionHandler {
        val roleHierarchy = RoleHierarchyImpl().apply {
            setHierarchy("ROLE_SUPER_ADMIN > ROLE_ADMIN > ROLE_DEVELOPER > ROLE_DRIVER > ROLE_USER")
        }
        val handler = DefaultWebSecurityExpressionHandler()
        handler.setRoleHierarchy(roleHierarchy)
        return handler;
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(coreMemberDetailService).passwordEncoder(BCryptPasswordEncoder())
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .authorizeRequests().antMatchers("/oauth/**").permitAll()
            .and()
            .formLogin()
            .and()
            .httpBasic()
    }
}