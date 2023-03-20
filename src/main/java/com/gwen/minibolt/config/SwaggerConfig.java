package com.gwen.minibolt.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Mini bolt Food Api", version = "v1.0.0",description = "mini bolt for all"))
public class SwaggerConfig {
}
