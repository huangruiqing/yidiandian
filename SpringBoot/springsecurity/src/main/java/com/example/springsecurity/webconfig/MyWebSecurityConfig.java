package com.example.springsecurity.webconfig;

import com.example.springsecurity.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName MyWebSecurityConfig
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 15:19
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//使用@EnableGlobalMethodSecurity(prePostEnabled = true)
// 这个注解，可以开启security的注解，我们可以在需要控制权限的方法上面使用@PreAuthorize，@PreFilter这些注解。
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public UserDetailsService userDetailsService() { //覆盖写userDetailsService方法 (1)
        return new MyUserDetailService();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().mvcMatchers("/","index","mylogin").permitAll()//默认不拦截资源的url(2)
                .anyRequest().authenticated().and()//其他都拦截
                .formLogin().loginPage("/mylogin")// 登录url请求路径 (3)
               .defaultSuccessUrl("/hello").permitAll()// 登录成功跳转路径url(4)
                .and().logout().permitAll();
        http.logout().logoutSuccessUrl("/");// 退出默认跳转页面 (5)

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth
        //    .inMemoryAuthentication()
        //    .withUser("root")
        //    .password("root")
        //    .roles("ADMIN", "USER")
        //    .and()
        //    .withUser("admin").password("admin")
        //    .roles("ADMIN", "USER")
        //    .and()
        //    .withUser("user").password("user")
        //    .roles("USER");

        //AuthenticationManager使用我们的 lightSwordUserDetailService 来获取用户信息
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder()); // （6）
    }

    /**
     * 默认不拦截静态资源的url pattern。我们也可以用下面的WebSecurity这个方式跳过静态资源的认证
     * @param web
     * @throws Exception
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resourcesDir/**");
    }
}
