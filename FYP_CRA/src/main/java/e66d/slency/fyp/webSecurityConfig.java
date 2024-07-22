/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:42:51 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */ 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {

	@Bean
	public MemberDetailsService memberDetailsService() {
		return new MemberDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(memberDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	                .requestMatchers("/data/add", "/data/edit/*", "/data/save", "/data/delete/*").authenticated() // Only allow authenticated users to access /data/**
	                .requestMatchers("/Member/add", "/Member/edit/*", "/Member/save", "/Member/delete/*").authenticated() // Only allow authenticated users to access /members/**
	                .requestMatchers("/").permitAll() // Home page is visible without logging in
					.requestMatchers("/bootstrap/**", "/excel/**").permitAll() // Static resources and Excel files, visible to all
	                .anyRequest().authenticated() // Other requests need authentication
	        ) // end of authorizeHttpRequests
	        .formLogin((login) -> login.loginPage("/login").permitAll().defaultSuccessUrl("/")) //Goes to homepage upon login
			.logout((logout) -> logout.logoutSuccessUrl("/")) //Goes to homepage upon logout					        
			.exceptionHandling((exceptionHandling) -> exceptionHandling.accessDeniedPage("/403"));

	        return http.build();
	 }

}
