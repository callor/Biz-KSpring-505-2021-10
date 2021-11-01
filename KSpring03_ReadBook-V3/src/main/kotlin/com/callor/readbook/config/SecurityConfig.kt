package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

// 프로젝트 설정을 위한 클래스다
@SpringBootConfiguration
// 프로젝트에 Spring Security 설정을 추가한다
// Spring Security 를 Customizing 하겠다
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    /**
     * 인증절차를 수행하는 policy 설정
     */
    override fun configure(http: HttpSecurity) {

        // client 로 부터
        // 전달된 Req 가 인가된 요청인가를 확인하겠다
//        http.authorizeRequests()
//            .antMatchers("/member/mypage")
//            .authenticated()
//        http.authorizeRequests()
//            .antMatchers("/**")
//            .permitAll()

        // antMatchers(), mvcMatcher() 등은
        // authorizeRequests() 함수와 chaining 관계에 있는
        // 함수들이다
        // authorizeRequests() 함수아래에 다수의 antMatchers() 를
        // 계속해서 추가 할수 있다
        http.authorizeRequests()
            // member/mypage 로 req(요청)이 오면
            // 인증 절차를 수행하라
            .antMatchers("/member/login").permitAll()
            .antMatchers("/member/mypage").authenticated()

            .antMatchers("/**").permitAll()

        // 단독으로 사용되는 method 함수들은
        // http.함수() 형식으로 사용한다
        // http.httpBasic()
        // http.formLogin()

        // 단독으로 사용되는 method 함수들을
        // chaining 방식으로 사용할때는 and() 함수로 연결해 준다
        //   .and().httpBasic() // popup 로그인
        // custom login 폼을 사용할때는 .and() 로 연결하지 말것
        http.formLogin() // 로그인 form 보이기`
            // security 기본 form 화면을 보이는 대신
            // 내가 만든 MemberController 의 login 으로
            // redirect 하라
            .loginPage("/member/login").permitAll()
            // custom login form 의 action 과 같은 Url 을 지정
            .loginProcessingUrl("/login")
//            .usernameParameter("userid")
//            .passwordParameter("pass")

        // logout 을 구현하겠다
        http.logout()
                // ${rootPath}/logout 으로 요청이 들어오면
                // logout 을 수행하라
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                
                // logout 이 정상적으로 수행되면
                // /member/mypage 로 redirect 를 수행하라
            .logoutSuccessUrl("/member/mypage")

    } // config(http) end


    /**
     * "{noop}12341234
     * Spring Security 에서 제공하는 password 정책
     * 5.x 버전이상에서는 의무적으로 password 를 DB 에 저장하거나
     * 비교연산등을 할때 반드시 암호화를 하도록 강제하고 있다
     *
     * 아직 암호화를 구현하지 않을 상태에서 테스트를 하기 위해서
     * 임시로 암호화 되지 않은 비밀번호를 사용해서
     * 비밀번호 비교를 하겠다 라는 의미의 메시지지     *
     */
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("callor")
            .password("{noop}12341234")
            .roles("USER", "AMIN")
    }
}



