package br.com.petcenter.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiV1() {
        return GroupedOpenApi.builder()
                .group("v1")
                .packagesToScan("br.com.petcenter.pedido.controller", "br.com.petcenter.carrinho.controller", "br.com.petcenter.cupom.controller")
                .pathsToMatch("/**")
                .build();
    }
}




