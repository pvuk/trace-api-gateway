package com.nl.trace.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 1. Centralized Service Discovery:
	Eureka helps your API Gateway dynamically discover services without hardcoding URLs.

	2. Dynamic Routing:
	The API Gateway (like Spring Cloud Gateway or Zuul) can route requests to services based on their names registered in Eureka.

	3. Scalability:
	As services scale up or down, Eureka keeps track of all instances, and the Gateway can load balance between them.

	4. Simplified Client Communication:
	Clients only talk to the Gateway, which abstracts away the complexity of the backend services.
	
	<p>Some more info..</p>
	@EnableDiscoveryClient in your API Gateway and microservices.
	
	<p>Some more info..</p>
	### Summary Table

| Feature               | Eureka Service Registry | API Gateway               |
|-----------------------|--------------------------|---------------------------|
| **Role**              | Service discovery        | Request routing & control |
| **Used by**           | Microservices            | Clients (and sometimes services) |
| **Knows about services** | Yes                  | Yes (via Eureka)          |
| **Handles traffic**   | No                       | Yes                       |


 * @author Venkata.Pulipati
 * @since Tuesday 29-July-2025 16:34:52
 */
@SpringBootApplication
//@EnableEurekaServer
@EnableDiscoveryClient
public class TraceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceApiGatewayApplication.class, args);
	}

}
