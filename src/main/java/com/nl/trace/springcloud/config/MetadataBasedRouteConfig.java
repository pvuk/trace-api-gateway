package com.nl.trace.springcloud.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Code Ref: Interview Q&A. How to configure Routes dynamically. 
 * Ctrl +H @Metadata 2. Access Metadata in Gateway
You can access this metadata programmatically in your gateway using a custom RouteDefinitionLocator or a RouteLocator.

Here’s an example using DiscoveryClient to read metadata and create routes dynamically:

<p>Some more Info</p>
✅ What This Does:
Reads all registered services from Eureka.
Checks if they have a gateway-path metadata.
Creates a route using that path and maps it to the service.

✅ Benefits of Metadata-Based Routing
| **Feature**              | **Benefit**                                               |
|--------------------------|-----------------------------------------------------------|
| Dynamic Routing          | No need to hardcode routes in `application.yml`.          |
| Service-Specific Paths   | Each service can define its own path via metadata.        |
| Centralized Logic        | Gateway handles routing logic based on metadata.          |


✅ Step 4: Access Services via Gateway
Now you can access services like:

http://trace-api-gateway/bank/... → routed to trace-bank
http://trace-api-gateway/cards/... → routed to trace-cards
No need to manually define each route!

✅ Benefits
Scalable: Easily supports 50+ services.
Flexible: Each service defines its own path.
Centralized: Routing logic lives in the gateway.

 * @author Venkata.Pulipati
 * @since Wednesday 30-July-2025 15:05:37
 */
@Configuration
public class MetadataBasedRouteConfig {
	private final Logger LOG = LoggerFactory.getLogger(MetadataBasedRouteConfig.class);
	
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * Dynamic Route Configuration
     * 
     * 🔍 What is gateway-path?
		It’s a metadata entry added to a service’s Eureka registration that tells the API Gateway:
		
		“When routing to this service, use this path prefix.”
		
		For example, in trace-bank gateway-path is mentioned as /bank:
		eureka:
		  instance:
		    metadata-map:
		      gateway-path: /bank
		
		This means that requests coming to http://trace-api-gateway/bank/** should be routed to trace-bank.

     * 
     * 
     * ✅ 1. Dynamic Route Creation
		Instead of manually defining routes for each service in the gateway, you can:
		
		Read gateway-path from Eureka metadata.
		Automatically create routes using that path.
		✅ 2. Service-Specific Routing
		Each service can define its own routing prefix, making it easier to:
		
		Organize endpoints.
		Avoid path conflicts.
		Apply filters or security rules per service.

     * @author Venkata.Pulipati
     * @since Wednesday 30-July-2025 15:21:22
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        discoveryClient.getServices().forEach(serviceId -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            if (!instances.isEmpty()) {
                ServiceInstance instance = instances.get(0);
                String path = instance.getMetadata().get("gateway-path");
                LOG.info("Route Path: {}", path);
                if (path != null) {
                    routes.route(serviceId, r -> r.path(path + "/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://" + serviceId));
                }
            }
        });

        return routes.build();
    }
}
