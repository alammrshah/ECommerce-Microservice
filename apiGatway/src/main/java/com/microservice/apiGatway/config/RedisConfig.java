package com.microservice.apiGatway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RedisConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    /**
     * This bean defines a KeyResolver that uses the client's IP address as the key for rate limiting.
     * It is used to identify unique clients based on their IP address.
     *
     * @return KeyResolver that resolves the key based on the client's IP address
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        // This resolver uses the IP address of the client as the key for rate limiting
        return exchange -> {
            String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            logger.info("Resolved client IP address for rate limiting: {}", ip);
            return Mono.just(ip);
        };
    }


}
