package com.web.student.search.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/bootstrap/**").antMatchers("/js/**").antMatchers("/image/**")
				.antMatchers("/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login", "/register", "/home", "/index", "/", "/about", "/show/profile/{username}")
				.permitAll().antMatchers("/profile").hasRole("USER")
				.antMatchers("/students", "/add/department", "/list/promo-code", "/update/promo-code",
						"/show/running/student", "/show/suspend/student", "/activate/student/{username}",
						"/suspend/student/{username}", "/list/promo/code", "/json/active/student",
						"/json/inactive/student", "/json/student/department")
				.hasRole("ADMIN").antMatchers("/json/show/all").permitAll().antMatchers("/auth/user/admin/register")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.loginProcessingUrl("/login").defaultSuccessUrl("/", true).and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from student where username=?")
				.authoritiesByUsernameQuery("select username, role from authorities where username=?")
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
