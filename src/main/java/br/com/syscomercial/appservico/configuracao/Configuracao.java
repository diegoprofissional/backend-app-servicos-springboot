package br.com.syscomercial.appservico.configuracao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class Configuracao {

    @Value("${keySetURI}")
    private String keySetUri;

    private static final Logger logger = LoggerFactory.getLogger(Configuracao.class);



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
logger.info(keySetUri);

      httpSecurity.oauth2ResourceServer(
              c -> c.jwt(
                      j -> j.jwkSetUri(keySetUri)
              )
      );

        httpSecurity.cors( c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(
                        List.of("http://192.168.0.87:3000", "http://localhost:3000", "http://www.servicospro.com:3001")
                );
                config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

                config.setAllowedHeaders(List.of("*"));
                return config;
            };
            c.configurationSource(source);
        });



        httpSecurity.csrf(c -> c.disable());

        httpSecurity.authorizeRequests()
                .requestMatchers("/api/admin/**").authenticated()
                .anyRequest().permitAll();
         ;

        return httpSecurity.build();

    }

}
