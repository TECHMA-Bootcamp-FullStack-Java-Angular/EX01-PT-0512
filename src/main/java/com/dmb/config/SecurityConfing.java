package com.dmb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfing {
	
	@Bean
	SecurityFilterChain fliterChain (HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.cors( cors -> corsConfigurationSource())
				.authorizeHttpRequests( auth -> auth
						
				/* 
				* De esta manera capturamos el nombre del usuario que se ha logeado.
				* luego en el controlador nos aseguramos esa persona sea la misma que creo el mensaje, si lo es podra editar y borrar.
				* Si no lo es el controlador SOLO EN EL METODO PUT lanazará un estado 403 no autorizado con el mesaje correspondiente.
				* 
			    */
					.requestMatchers("/api/v1/visit/{id}/{name}").access(new WebExpressionAuthorizationManager("#name == authentication.name"))
					.requestMatchers("/swagger-ui/**","/doc.html").permitAll()
					.anyRequest().authenticated()
				)
				.formLogin( e -> e.permitAll()
						.successHandler(swaggerRedirect()))		
				.build();
	} 
	
	// CORS Configuration Bean
    @Bean
   CorsConfigurationSource corsConfigurationSource() {
    	
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");      // Allow all origins or Arrays.asList("http://localhost:4200","http://localhost:3000")
        configuration.addAllowedMethod("*");      // Allow all methods or List.of("GET", "POST", "PUT", "DELETE")
        configuration.addAllowedHeader("*");      // Allow all headers
        configuration.setAllowCredentials(true);  // Allow sending of authentication cookies
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    

    public AuthenticationSuccessHandler swaggerRedirect(){
        return ((request, response, authentication) -> {
            response.sendRedirect("/doc.html");
        });
    }

}