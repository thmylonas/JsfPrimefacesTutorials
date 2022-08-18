package com.thomasmylonas.spring_mvc_jsf_pf_web_app._spring_security._spring_security_config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;*/

//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackages = {"com.thomasmylonas.spring_mvc_jsf_pf_web_app"})
public class SecurityConfig extends SecurityConfigDeprecated {

    /*@Autowired
    private PasswordEncoder bCryptPasswordEncoder;*/

    /**
     * This bean replaces the deprecated method:
     * "@Override public void configure(WebSecurity web) throws Exception {}"
     * <p>
     * The "WebSecurity", which is created by WebSecurityConfiguration
     * 1. creates the "springSecurityFilterChain" and
     * 2. can be used to create other FilterChainProxy beans.
     *
     * @return The "WebSecurityCustomizer"
     */
    /*@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        /-
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
            }
        };
        -/
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }*/

    /**
     * This bean replaces the deprecated method:
     * "@Override protected void configure(HttpSecurity http) throws Exception {}"
     *
     * @param http The "HttpSecurity"
     * @return The "SecurityFilterChain"
     * @throws Exception An Exception
     */
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Default implementation
        http
                .authorizeRequests() // The requests which will be authorized are...
                .anyRequest().authenticated() // ...all authenticated requests
                .and()
                .formLogin() // Authentication via predefined login page-form
                .and()
                .httpBasic(); // Authentication via Basic method

        // Usual implementation
        http
                //.csrf().disable() // Disable CSRF protection - NEVER do this
                .authorizeRequests() // The requests which will be authorized are...
                .antMatchers("/spitters/me").authenticated() // ...all these authenticated requests...
                .antMatchers(HttpMethod.POST, "/spittles").authenticated() // ...& all these authenticated requests...
                .antMatchers("/spitters/**", "/spittles/mine").authenticated() // ...& all these authenticated requests...
                .regexMatchers("/spitters/.*").authenticated() // ...& all these authenticated requests...
                .antMatchers("/**").hasRole("USER") // ...& all these requests with this role...
                .antMatchers("/spitters/you").hasAuthority("ROLE_USER") // ...& all these requests with this authority...
                .antMatchers(HttpMethod.POST, "/spittles2").hasAuthority("ROLE_USER") // ...& all these requests with this authority...
                .antMatchers("/spitter/him").access("hasRole('SPITTER')")
                .antMatchers("/spitter/her").access("hasRole('SPITTER') and hasIpAddress('192.168.1.2')") // Assign more access methods in the same path
                .anyRequest().permitAll() // ...and finally, all the remaining not authenticated requests
                .and()
                .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure() // Require HTTPS
                .antMatchers("/").requiresInsecure() // Require HTTP
                .and()
                .formLogin() // Authentication via predefined login page-form
                .loginPage("/spittr/login") // Authentication via custom login page-form
                .and()
                .httpBasic()
                .realmName("MyBasicRealm");

        // Implementation with OpenID-Connect
        http
                .authorizeRequests()
                .antMatchers("/**").hasRole("USER")
                .and()
                .openidLogin() // OpenIDLoginConfigurer
                .loginPage("/login") // OpenIDLoginConfigurer
                .permitAll() // OpenIDLoginConfigurer
                .authenticationUserDetailsService(new AutoProvisioningUserDetailsService()) // OpenIDLoginConfigurer
                .attributeExchange("https://www.google.com/.*") // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("email").type("http://axschema.org/contact/email").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
                .and() // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("firstname").type("http://axschema.org/namePerson/first").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
                .and() // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("lastname").type("http://axschema.org/namePerson/last").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
                .and() // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .and() // OpenIDLoginConfigurer
                .attributeExchange(".*yahoo.com.*") // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("email").type("http://schema.openid.net/contact/email").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
                .and() // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("fullname").type("http://axschema.org/namePerson").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
                .and() // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .and() // OpenIDLoginConfigurer
                .attributeExchange(".*myopenid.com.*") // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("email").type("http://schema.openid.net/contact/email").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
                .and() // OpenIDLoginConfigurer.AttributeExchangeConfigurer
                .attribute("fullname").type("http://schema.openid.net/namePerson").required(true) // OpenIDLoginConfigurer.AttributeExchangeConfigurer.AttributeConfigurer
        ;

        // Other implementations
        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().openidLogin().permitAll();

        return http.build();
    }*/

    /**
     * InMemoryAuthentication: Enable an in-memory user store
     * <p>
     * This bean replaces the deprecated method:
     * "@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {}"
     *
     * @return The "InMemoryUserDetailsManager"
     */
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        inMemoryUserDetailsManager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("password"))
                .roles("USER").authorities("ROLE_USER")
                .build());
        inMemoryUserDetailsManager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("password"))
                .roles("USER", "ADMIN").authorities("ROLE_USER", "ROLE_ADMIN")
                .build());
        // The username must match the OpenID of the user you are logging in with
        inMemoryUserDetailsManager.createUser(User.withUsername("https://www.google.com/accounts/o8/id?id=lmkCn9xzPdsxVwG7pjYMuDgNNdASFmobNkcRPaWU")
                .password(bCryptPasswordEncoder.encode("password"))
                .roles("USER").authorities("ROLE_USER")
                .build());

        return inMemoryUserDetailsManager;
    }*/

    /**
     * JdbcAuthentication
     * <p>
     * This bean replaces the deprecated method:
     * "@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {}"
     *
     * @return The "JdbcUserDetailsManager"
     */
    /*@Bean
    public JdbcUserDetailsManager userDetailsService2() {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(); // new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setDataSource(dataSource);

        /-
        Set Schema/DDL scripts.
        If the following is not set, the configuration will be based on the default queries:
        - JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY,
        - JdbcDaoImpl.DEF_AUTHORITIES_BY_USERNAME_QUERY,
        - JdbcDaoImpl.DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY
        -/
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, true " +
                "from Spitter where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, 'ROLE_USER' " +
                "from Spitter where username=?");
        jdbcUserDetailsManager.setGroupAuthoritiesByUsernameQuery("query_string");

        /-
        Create users
        -/
        jdbcUserDetailsManager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("password"))
                .roles("USER").authorities("ROLE_USER")
                .build());
        jdbcUserDetailsManager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("password"))
                .roles("USER", "ADMIN").authorities("ROLE_USER", "ROLE_ADMIN")
                .build());

        return jdbcUserDetailsManager;
    }*/
}
