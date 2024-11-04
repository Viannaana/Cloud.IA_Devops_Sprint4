package br.com.NTJ.tech.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "Vitor Pereira", email = "rm551831@fiap.com.br"),
                title = "Challenge NTJ.Tech",
                description = "Blog da Claud.IA com autenticação e documentação",
                version = "1.0"),
        servers = @Server(url = "http://localhost:8080"),
        security = @SecurityRequirement(name = "Claud.IAJwt")
)
@SecurityScheme(
        name = "Claud.IAJwt",
        description = "Autenticação do sistema JWT",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme = "challenge",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
