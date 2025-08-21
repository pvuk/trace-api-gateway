package com.nl.trace.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Venkata.Pulipati
 * @since Tuesday 29-July-2025 18:35:31
 */
//@Component
public class JwtAuthenticationFilter 
//implements GatewayFilter 
{

//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//
//        String token = authHeader.substring(7);
//        // Validate token (you can use a JWT library like jjwt or java-jwt)
//        boolean isValid = validateToken(token); // Implement this method
//
//        if (!isValid) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//
//        return chain.filter(exchange);
//    }
//
//    private boolean validateToken(String token) {
//        // Token validation logic here
//        return true; // Replace with actual validation
//    }
}
