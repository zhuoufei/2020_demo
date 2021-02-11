package com.zf.mo.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.zf.mo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;
import java.util.Properties;


@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //------------注销登录-----------------------
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                //开放capmatch.jpg的权限
                .antMatchers("/app/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .rememberMe().userDetailsService(myUserDetailsService)
                //持久化令牌方案
                .tokenRepository(jdbcTokenRepository)
                .and()
                .csrf().disable();

        //-------------持久化自动加密-----------------------
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
//        http.authorizeRequests()
//                .antMatchers("/admin/api/**").hasRole("ADMIN")
//                .antMatchers("/user/api/**").hasRole("USER")
//                //开放capmatch.jpg的权限
//                .antMatchers("/app/api/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .rememberMe().userDetailsService(myUserDetailsService)
//                //持久化令牌方案
//                .tokenRepository(jdbcTokenRepository)
//                .and()
//                .csrf().disable();

        //------------散列加密自动登录--------------------------
//        http.authorizeRequests()
//                .antMatchers("/admin/api/**").hasRole("ADMIN")
//                .antMatchers("/user/api/**").hasRole("USER")
//                //开放capmatch.jpg的权限
//                .antMatchers("/app/api/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
////                .loginPage("/login_remember.html")
////                .loginProcessingUrl("/login")
////                .failureHandler(new MyAuthenticationFailureHandler())
//                .permitAll()
//                .and()
//                .rememberMe().userDetailsService(myUserDetailsService)
//                .key("bluroo") //指定key 重启服务 cookie不会失效
//                .and()
//                .csrf().disable();


//        //-------------图片认证-------------------
////        http.authorizeRequests()
////                .antMatchers("/admin/api/**").hasRole("ADMIN")
////                .antMatchers("/user/api/**").hasRole("USER")
////                //开放capmatch.jpg的权限
////                .antMatchers("/app/api/**","/captcha.jpg").permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login.html")
////                .loginProcessingUrl("/auth/form")
////                .failureHandler(new MyAuthenticationFailureHandler())
////                .permitAll()
////                .and()
////                .csrf().disable();
////        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);



        //---------------登录权限用户验证权--------------
//        http.authorizeRequests()
//                .antMatchers("/admin/api/**").hasRole("ADMIN")
//                .antMatchers("/user/api/**").hasRole("USER")
//                .antMatchers("/app/api/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .csrf().disable();
        //--------------用户基本登录认证-------------
        /*http.authorizeRequests().anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")//指定登录页面
                .loginProcessingUrl("/login")//指定登录访问路径
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=UTF-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"error_code\":\"0\",\"message\":\"欢迎进入登录页面\"}");
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();*/

    }

    //默认提公jdbcUserDetailsManager登录权限
//    @Bean
//    public UserDetailsService userDetailsService2(){
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//        manager.setDataSource(dataSource);
//        if(!manager.userExists("user")){
//            manager.createUser(User.withUsername("user").password("123").roles("USER").build());
//        }
//        if(!manager.userExists("admin")){
//            manager.createUser(User.withUsername("admin").password("123").roles("ADMIN","USER").build());
//        }
//        return manager;
//    }
    //内存中设置登录权限
//    @Bean
//    public UserDetailsService userDetails(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("123").roles("USER").build());
//        manager.createUser(User.withUsername("admin").password("123").roles("ADMIN","USER").build());
//        return manager;
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public Producer captcha(){
        //配置图形验证码 基本配置参数
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width","150");
        properties.setProperty("kaptcha.image.height","50");
        properties.setProperty("kaptcha.textproducer.char.string","0123456789");
        properties.setProperty("kaptcha.textproducer.char.length","4");
        Config config = new Config(properties);
        //使用默认的图形验证码
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;

    }
}
