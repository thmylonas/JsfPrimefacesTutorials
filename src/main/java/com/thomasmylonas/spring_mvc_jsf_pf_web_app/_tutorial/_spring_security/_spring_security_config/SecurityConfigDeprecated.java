package com.thomasmylonas.spring_mvc_jsf_pf_web_app._tutorial._spring_security._spring_security_config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.openid.OpenIDAuthenticationToken;

import javax.sql.DataSource;
import java.util.List;*/

/**
 * From the "SpringSecurity v5.7.1 and after" the following code is "Deprecated"
 */
//@Configuration
//@EnableWebSecurity // The "@EnableWebMvcSecurity" is deprecated
//@ComponentScan(basePackages = {"com.thomasmylonas.spring_mvc_jsf_pf_web_app"})
//@Deprecated
public class SecurityConfigDeprecated /*extends WebSecurityConfigurerAdapter*/ {

	/*
	This configuration, without overriding any of the "configure()" methods,
	will lock down the application so tightly that nobody can get in!
	*/

    /*@Autowired
    protected DataSource dataSource;

    @Bean(name = "pbkdf2PasswordEncoder")
    public PasswordEncoder pbkdf2PasswordEncoder() {
        return new Pbkdf2PasswordEncoder("53cr3t");
    }

    @Bean(name = "bCryptPasswordEncoder")
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    /*
    Spring's default queries for "jdbcAuthentication"
    */
    private static final String DEF_USERS_BY_USERNAME_QUERY =
            "select username, password, enabled " +
                    "from users " +
                    "where username = ?"; // JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY
    private static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "select username, authority " +
                    "from authorities " +
                    "where username = ?"; // JdbcDaoImpl.DEF_AUTHORITIES_BY_USERNAME_QUERY
    private static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
            "select g.id, g.group_name, ga.authority " +
                    "from groups g, group_members gm, group_authorities ga " +
                    "where gm.username=? " +
                    "and g.id = ga.group_id " +
                    "and g.id = gm.group_id"; // JdbcDaoImpl.DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY

    /**
     * Implement this method to configure Spring Security’s filter chain
     * <p>
     * The "WebSecurity", which is created by WebSecurityConfiguration
     * 1. creates the "springSecurityFilterChain" and
     * 2. can be used to create other FilterChainProxy beans.
     */
    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }*/

    /**
     * Implement this method to configure how requests are secured by interceptors
     *
     * @param http The "HttpSecurity"
     * @throws Exception An Exception
     */
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {

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
    }*/

    /**
     * Implement this method to configure user-details services
     *
     * @param auth The "AuthenticationManagerBuilder"
     * @throws Exception An Exception
     */
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // InMemoryAuthentication
        auth
                .inMemoryAuthentication() // Enable an in-memory user store
                .withUser("user").password("password") // UserDetailsManagerConfigurer.UserDetailsBuilder
                .roles("USER").authorities("ROLE_USER") // UserDetailsManagerConfigurer.UserDetailsBuilder
                .and()
                .withUser("admin").password("password") // UserDetailsManagerConfigurer.UserDetailsBuilder
                .roles("USER", "ADMIN").authorities("ROLE_USER", "ROLE_ADMIN") // UserDetailsManagerConfigurer.UserDetailsBuilder
                .and()
                // the username must match the OpenID of the user you are logging in with
                .withUser("https://www.google.com/accounts/o8/id?id=lmkCn9xzPdsxVwG7pjYMuDgNNdASFmobNkcRPaWU")
                .password("password").roles("USER").authorities("ROLE_USER");

        // JdbcAuthentication
        auth
                .jdbcAuthentication() // JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder>
                .dataSource(dataSource)
                /-
                Set Schema/DDL scripts.
                If the following is not set, the configuration will be based on the default queries:
                - JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY,
                - JdbcDaoImpl.DEF_AUTHORITIES_BY_USERNAME_QUERY,
                - JdbcDaoImpl.DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY
                -/
                .usersByUsernameQuery("select username, password, true " +
                        "from Spitter where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' " +
                        "from Spitter where username=?")
                .groupAuthoritiesByUsername("query_string")
                .passwordEncoder(bCryptPasswordEncoder());
    }*/

    /*
    Other methods
    */
    /*public static class AutoProvisioningUserDetailsService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {
        public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException {
            List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_USER");
            return new User(token.getName(), "", authorityList);
        }
    }*/
}

/*
Another way, not so easy to implement
public class SecurityConfig implements WebSecurityConfigurer

***********************************************************

Other methods of "AuthenticationManagerBuilder"
--------------------------------------------------
and() // Used for chaining configuration
password(String) // Specifies the user's password
roles(String…) // Specifies one or more roles to assign to the user 
authorities(String…) // Specifies one or more authorities to grant to the user
authorities(GrantedAuthority…) // Specifies one or more authorities to grant to the user
authorities(List<? extends GrantedAuthority>) // Specifies one or more authorities to grant to the user
// roles() is a shortcut for authorities(), prefixed with ROLE_
credentialsExpired(boolean) // Defines if the credentials are expired or not
accountExpired(boolean) // Defines if the account is expired or not
accountLocked(boolean) // Defines if the account is locked or not
disabled(boolean) // Defines if the account is disabled or not

***********************************************************

PasswordEncoder
------------------
public interface PasswordEncoder {
	String encode(CharSequence rawPassword);
	boolean matches(CharSequence rawPassword, String encodedPassword);
}

***********************************************************

Implementations (Usable)
--------------------------
BCryptPasswordEncoder, SCryptPasswordEncoder, Pbkdf2PasswordEncoder, DelegatingPasswordEncoder

***********************************************************

Implementations (Deprecated)
------------------------------
StandardPasswordEncoder, NoOpPasswordEncoder, Md4PasswordEncoder, MessageDigestPasswordEncoder, 
LdapShaPasswordEncoder

***********************************************************

Matchers
-----------
antMatchers(HttpMethod method)
antMatchers(String... antPatterns)
antMatchers(HttpMethod method, String... antPatterns)
---------------------------------------------------------
regexMatchers(String... regexPatterns)
regexMatchers(HttpMethod method, String... regexPatterns)

***********************************************************

Access methods [like permitAll(), authenticated()]
----------------------------------------------------
1.
These methods can be applied in a specific order.
We must configure the most specific request path patterns first & 
the least specific ones last (eg.anyRequest()).
If not, the least specific paths will hide the more specific ones.
2.
Most of these methods are 1-dimensional. We cannot use 2 or more methods on the same path.
---------------------------------------------------------
authenticated() // Allows access to authenticated users
fullyAuthenticated() // Allows access if the user is fully authenticated (not remembered)
permitAll() // Allows access unconditionally
denyAll() // Denies access unconditionally
hasRole(String) // Allows access if the user has the given role
hasAnyRole(String…) // Allows access if the user has any of the given roles
hasAuthority(String) // Allows access if the user has the given authority
hasAnyAuthority(String…) // Allows access if the user has any of the given authorities
hasIpAddress(String) // Allows access if the request comes from the given IP address
not() // Negates the effect of any of the other access methods
rememberMe() // Allows access for users who are authenticated via remember-me
anonymous() // Allows access to anonymous users
access(String) // Allows access if the given SpEL expression evaluates to true

***********************************************************

Access with Spring Expression Language (SpEL)
-----------------------------------------------
1. SpEL extends the access methods list
2. We cannot use 2 or more methods on the same path.
---------------------------------------------------------
isAuthenticated() // True if the user is authenticated
isFullyAuthenticated() // True if the user is fully authenticated (not authenticated with remember-me)
authentication // The user's authentication object
permitAll // Always evaluates to true
denyAll // Always evaluates to false
hasRole(role) // True if the user has the given role
hasAnyRole(list of roles) // True if the user has any of the given roles
hasIpAddress(IP address) // True if the request comes from the given IP address
isRememberMe() // True if the user was authenticated via remember-me
principal // The user's principal object
isAnonymous() // True if the user is anonymous
*/
