package com.nl.trace.springcloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 📋 2. Logging Filter
	This filter logs request details like path, method, and headers.

 * @author Venkata.Pulipati
 * @since Tuesday 29-July-2025 18:17:59
 */
@Component
public class LoggingFilter implements GatewayFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        logger.info("Request Path: {}", request.getPath());
        logger.info("Request Method: {}", request.getMethod());
        logger.info("Request Headers: {}", request.getHeaders());

        return chain.filter(exchange);
    }
}
