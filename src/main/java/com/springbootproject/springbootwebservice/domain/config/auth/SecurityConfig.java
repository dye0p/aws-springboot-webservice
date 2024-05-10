package com.springbootproject.springbootwebservice.domain.config.auth;

import com.springbootproject.springbootwebservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfig) ->
                        csrfConfig.disable())
                .headers((headersConfig) ->
                        headersConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable())
                )
                .authorizeHttpRequests((authorizeRequest) ->
                        authorizeRequest
                                .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                                .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
                                .anyRequest().authenticated() //설정된 값 이외 나머지 URL들을 나타냄
                )
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/"))
                .oauth2Login((oauth2) -> oauth2
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                .userService(customOAuth2UserService)));

//                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}

