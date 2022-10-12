package org.sayco.sirem.electronicbill.controller.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Clase para mostrar las caracteristicas customizadas de la interfaz de swagger
 */
@OpenAPIDefinition(info = @Info(title = "Factura electronica API", version = "1.0", description = "Facturacion electronica"))
@Configuration
public class OpenApiConfiguration {
}
