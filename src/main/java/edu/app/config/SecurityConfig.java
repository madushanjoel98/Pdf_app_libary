package edu.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 http
         .csrf().disable()
         .authorizeRequests()
             .antMatchers("/api/**").permitAll()
             .antMatchers("/img/**","/public/**","/css/**", "/js/**", "/assets/**", "/plugins/**","/DataTables/**").permitAll()
             .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
             .and()
         .logout()
             .logoutUrl("/logout")
             .logoutSuccessUrl("/login?logout")
             .clearAuthentication(true)
             .permitAll();
		
//        http
//            .authorizeHttpRequests((auth) -> auth
//                .("/api/**")
//                .permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .successForwardUrl("/")
//                .permitAll()
//            )
//            .logout((logout) -> logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .permitAll());
 

        return http.build();
    }
	
	
}
