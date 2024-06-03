package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(r -> r.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(r -> r.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(r -> r.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .build();
    }
}
