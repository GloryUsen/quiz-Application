package com.glory.quizApp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                contact = @Contact(name = "Glory-anwana", email = "ganwana89@gmail.com", url = "https://www.github.com/"),
                description = "Open API documentation for Spring security.",
                title = "quizApp",
                version = "1.0",
                license = @License(name = "Apache License", url = "https://www.apache.org/licenses/LICENSE-2"),
                termsOfService = "Glory'sWork"
        ),
        servers = {
                @Server(
                        description = "Dev-Glory",
                        url = "http://localhost:8082"
                ),

        },
        security = {
                @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authentication")
        }
)

@io.swagger.v3.oas.annotations.security.SecurityScheme(
        name = "Bearer Authentication",
        description = "JWT Authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiSwagger {
//http://localhost:9090/swagger-ui/index.html#
// http://localhost:8082/swagger-ui/index.html#

}