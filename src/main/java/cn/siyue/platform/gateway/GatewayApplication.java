/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * gateway应用入口
 */
@EnableFeignClients
@SpringCloudApplication
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  /**
   *
   *如果使用了注册中心（如：Eureka），进行控制则需要增加如下配置
   */
  @Bean
  public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
    return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
  }


}
