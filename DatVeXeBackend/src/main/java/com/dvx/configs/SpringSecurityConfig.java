/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
//import com.dvx.services.LoginSuccessHandler;
import com.dvx.services.impl.LoginSuccessHandlerImpl;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Asus
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.dvx.controllers",
    "com.dvx.repositories",
    "com.dvx.configs",
    "com.dvx.services","com.dvx.APIs"

})
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private OncePerRequestFilter jwtFilter;

    @Autowired
    private LoginSuccessHandlerImpl loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dfdymgmvq",
                        "api_key", "449625188343825",
                        "api_secret", "dyQEMyFtYPcVU-7nrdVaa4MUF7c",
                        "secure", true));
        return cloudinary;
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
    //dang lam
//    @Bean
//    public JavaMailSender gmailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("trungh7430@gmail.com");
//        mailSender.setPassword("capd nruj nclr atnu");
//
//        Properties javaMailProperties = new Properties();
//        javaMailProperties.put("mail.smtp.starttls.enable", "true");
//        javaMailProperties.put("mail.smtp.auth", "true");
//        javaMailProperties.put("mail.transport.protocol", "smtp");
//        javaMailProperties.put("mail.debug", "true");
//
//        mailSender.setJavaMailProperties(javaMailProperties);
////        Session session = Session.getInstance(mailSender.getJavaMailProperties(),
////                new javax.mail.Authenticator() {
////            protected PasswordAuthentication getPasswordAuthentication() {
////                return new PasswordAuthentication("trungh7430@gmail.com","capd nruj nclr atnu");
////            }
////        });
//        return mailSender;
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    private List<String> publicUrl = List.of("/",
//            "/api/auth/**",
            "/api/**/"
    );
    
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                
                .antMatchers("/admin/**/").permitAll()
//                .hasAuthority("ADMIN")
//                .anyRequest().authenticated()
//                .antMatchers(publicUrl.toArray(String[]::new))
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/admin/", true)
                .failureUrl("/login?error")
                .and().logout().logoutSuccessUrl("/login");
//        http.formLogin().successHandler(this.loginSuccessHandler);

//        http.exceptionHandling()
//                .accessDeniedPage("/login?accessDenied");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
