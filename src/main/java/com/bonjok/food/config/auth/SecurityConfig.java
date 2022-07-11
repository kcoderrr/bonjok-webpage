package com.bonjok.food.config.auth;

import com.bonjok.food.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()
                .and() //h2-console화면 사용 옵션
                    .authorizeRequests() //url관리 옵션의 시작점
                        .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/posts/list","/mem/signin","/img/**").permitAll() //권한 관리대상 (url,http)
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //지정된 url가진 user에게 열람권한 제공
                        .anyRequest().authenticated()
                .and() //이외의 로그인한 사용자들 모두
                    .formLogin().loginPage("/mem/signin")
                .and()
                    .logout().logoutSuccessUrl("/")
                .and() //로그아웃 설정 진입점, 성공시 "/"로 이동
                    .oauth2Login()
                        .loginPage("/mem/signin")
                        .userInfoEndpoint().userService(customOAuth2UserService); //oauth2 로그인진입점, 정보설정, sns로그인 성공 후 조치 인터페이스 등록

    }
}
