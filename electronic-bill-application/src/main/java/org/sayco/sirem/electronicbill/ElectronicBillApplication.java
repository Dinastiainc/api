package org.sayco.sirem.electronicbill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase principal donde arranca a la aplicacion con las configuraciones del framework Spring Boot
 */
@SpringBootApplication
public class ElectronicBillApplication extends SpringBootServletInitializer {

    /**
     * Metodo principal de la aplicacion donde se inicia el sistema
     * @param args: parametros de inicio para iniciar la api
     */
    public static void main(String[] args) {
        SpringApplication.run(ElectronicBillApplication.class, args);
    }
}
