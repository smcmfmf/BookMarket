package kr.ac.kopo.smcmfmf.bookmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 비밀번호를 암호화
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("Admin") // 아이디
                .password(passwordEncoder().encode("Admin1234")) // 비밀번호를 암호화
                .roles("ADMIN") // 역할 정의
                .build();
        return new InMemoryUserDetailsManager(admin); // 사용자 정의
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // 웹 보안 취약점 공격 방지
                .authorizeHttpRequests(
                        authorize -> authorize // Lamda식으로 간소화
                                .requestMatchers("/books/add").hasRole("ADMIN")
                                .requestMatchers("/order/list").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )
//                .formLogin(Customizer.withDefaults()); // 기본 로그인 폼 사용
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/books/add")
                        .failureUrl("/loginfailed")
                        .usernameParameter("username")
                        .passwordParameter("password")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃을 할 때
                        .logoutSuccessUrl("/login")); // 로그아웃이 완료된 뒤 로그인 URI로 이동
        return http.build(); // http의 객체를 생성한 후 반환
    }
}
