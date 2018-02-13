package pl.michalskrzypek.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("pl.michalskrzypek")
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Bean(name = "passwordEncoder")
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select email ,password, active from account where email=?")
				.authoritiesByUsernameQuery("select email, role from account where email = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/show/**").permitAll()
				.antMatchers("/manage/**").hasAnyAuthority("ADMIN", "MANAGER").antMatchers("/cart/**")
				.hasAuthority("CUSTOMER").antMatchers("/profile/**").hasAnyAuthority("ADMIN","CUSTOMER").antMatchers("/checkout/**").hasAuthority("CUSTOMER")
				.and().formLogin().loginPage("/login").loginProcessingUrl("/authenticate")
				.and().logout().permitAll()
				.logoutSuccessUrl("/home?success=logout").and().exceptionHandling().accessDeniedPage("/access-denied");
	}
}