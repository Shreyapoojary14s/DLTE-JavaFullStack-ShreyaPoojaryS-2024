package account.webservice.model.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import project.dao.accountmodel.security.MyBankCustomersService;
import project.dao.accountmodel.services.AccountServices;

import java.util.Arrays;
import java.util.ResourceBundle;

@Configuration
public class CustomerSecureConfig{

    ResourceBundle resourceBundle = ResourceBundle.getBundle("account");
    @Autowired
    MyBankCustomersService myBankCustomersService;

    AuthenticationManager authenticationManager;

    @Autowired
    CustomersFailureHandler customersFailureHandler;

    @Autowired
    CustomersSucccessHandler customersSucccessHandler;

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


    // CORS Configuration
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList(resourceBundle.getString("frontend.link")));//task

        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic();
        httpSecurity.formLogin().usernameParameter("username").failureHandler(customersFailureHandler).successHandler(customersSucccessHandler);
        httpSecurity.formLogin().loginPage("/customer/").usernameParameter("username").failureHandler(customersFailureHandler).successHandler(customersSucccessHandler);

        httpSecurity.csrf().disable();
        httpSecurity.cors();
        httpSecurity.authorizeRequests().antMatchers("/profile/register").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/v3/api-docs").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/css/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/images/**").permitAll();
        httpSecurity.logout().permitAll();
        httpSecurity.authorizeRequests().antMatchers("/customer/").permitAll();
        httpSecurity.authorizeRequests().anyRequest().authenticated();

        AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(myBankCustomersService);
        authenticationManager = builder.build();
        httpSecurity.authenticationManager(authenticationManager);
        return httpSecurity.build();
    }

}