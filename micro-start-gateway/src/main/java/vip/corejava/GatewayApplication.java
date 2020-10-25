package vip.corejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author xcl
 * @version 2020/10/23
 */
@SpringBootApplication
public class GatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org"))

                .route("routh_app", r -> r
                        .path("/app/**")
                        .filters(f -> f.rewritePath("/app/(?<segment>.*)", "/${segment}"))
                        .uri("lb://micro-start-app"))

                .route("routh_mgmt", r -> r
                        .path("/mgmt/**")
                        .filters(f -> f.rewritePath("/mgmt/(?<segment>.*)", "/${segment}"))
                        .uri("lb://micro-start-mgmt"))

                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
