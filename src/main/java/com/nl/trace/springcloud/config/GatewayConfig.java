package com.nl.trace.springcloud.config;

//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nl.trace.springcloud.filter.JwtAuthenticationFilter;
import com.nl.trace.springcloud.filter.LoggingFilter;

/**
 * The RouteLocator bean in your Spring Cloud Gateway configuration is used to define custom routing rules for your API gateway. Here's a breakdown of its purpose and how it works:

	📌 Purpose of RouteLocator
	RouteLocator is a core component in Spring Cloud Gateway that defines how incoming HTTP requests are routed to downstream services. It allows you to configure routes programmatically using the RouteLocatorBuilder.

	🔹 What It Does:
	* Defines two routes:
	1. user-service: Any request matching /users/** is routed to the service registered as USER-SERVICE in your service registry (like Eureka).
	2. order-service: Any request matching /orders/** is routed to ORDER-SERVICE.
	🔹 Key Components:
	* @Bean: Registers this method's return value as a Spring bean.
	* RouteLocatorBuilder: A fluent API to build routes.
	* path("/users/**"): Matches incoming request paths.
	* uri("lb://USER-SERVICE"): Uses load balancing (lb://) to forward the request to the appropriate service instance.

	✅ Benefits
	* Centralized Routing: All routing logic is defined in one place.
	* Dynamic Load Balancing: Integrates with service discovery (e.g., Eureka).
	* Scalability: Easily add more routes as your microservices grow.
	* Flexibility: You can add filters, predicates, and custom logic.
	
 * @author Venkata.Pulipati
 * @since Tuesday 29-July-2025 18:30:13
 */
//@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//            .route("trace-bank-service", r -> r.path("/bank/**")
//                .uri("lb://TRACE-BANK-SERVICE"))
//            .route("trace-cards-service", r -> r.path("/cards/**")
//                .uri("lb://TRACE-ORDER-SERVICE"))
//            .build();
//    }
    
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder,
//                                           JwtAuthenticationFilter jwtFilter,
//                                           LoggingFilter loggingFilter) {
//        return builder.routes()
//            .route("user-service", r -> r.path("/users/**")
//                .filters(f -> f.filter(jwtFilter).filter(loggingFilter))
//                .uri("lb://USER-SERVICE"))
//            .route("order-service", r -> r.path("/orders/**")
//                .filters(f -> f.filter(loggingFilter))
//                .uri("lb://ORDER-SERVICE"))
//            .build();
//    }

}
