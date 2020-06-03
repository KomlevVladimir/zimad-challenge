package com.vladimirkomlev.zimadchallenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    private final AppProperties appProperties;

    @Autowired
    public RestTemplateConfig(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().requestFactory(new ClientHttpRequestFactorySupplier())
                .interceptors((ClientHttpRequestInterceptor) (request, body, execution) -> {
                    request.getHeaders().setBearerAuth(appProperties.getAuthToken());
                    return execution.execute(request, body);
                }).build();
    }
}
