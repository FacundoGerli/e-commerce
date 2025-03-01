package config;

import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
;import static org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.anyExchange;
import static org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.pathMatchers;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfiguration {

    @Value("${spring.security.keycloakJwksUrl}")
    private String keycloakJwksUrl;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
                .oauth2Login(Customizer.withDefaults())
                .authorizeExchange(exchange -> exchange
                    .pathMatchers("/public/**").permitAll()
                        .anyExchange().authenticated()
                )
                .addFilterAfter(jwtUserIdFilter(), SecurityWebFiltersOrder.AUTHORIZATION)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return httpSecurity.build();
    }
    private WebFilter jwtUserIdFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            
            if (token == null || !token.startsWith("Bearer ")) return chain.filter(exchange);
            
            token = token.substring(7);
            Jwt jwt = decodeJwt(token);
            String userId = jwt != null ? jwt.getClaimAsString("sub") : null;
            if (userId == null) return chain.filter(exchange);
            exchange.getRequest().mutate()
                    .header("X-User-Id", userId)
                    .build();
            return chain.filter(exchange);
        };
    }

    private Jwt decodeJwt(String token) {
        try {
            JwtDecoder jwtDecoder = jwtDecoder();
            return jwtDecoder.decode(token);
        } catch (Exception e) {
            return null;
        }
    }
    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(keycloakJwksUrl).build();
    }
}
