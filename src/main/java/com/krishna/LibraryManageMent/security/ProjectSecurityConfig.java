/*
package com.krishna.LibraryManageMent.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        // 1. Cors
        http.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowCredentials(true);
                return config;
            }
        }));
        // http.cors(cors -> {
        //     cors.configurationSource(new CorsConfigurationSource(){

        //         @Override
        //         public CorsConfiguration getCorsConfiguration(HttpServletRequest arg0) {
        //             CorsConfiguration config = new CorsConfiguration();
        //             config
        //             return config;

        //         }

        //     });
        // });

        // 2. CSRF

        // 3. Authorization

        // 4. Defaults
        return http.build();
    }
}
*/