package org.sayco.sirem.electronicbill.controller.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * La interfaz se encarga de adminstrar las excepciones
 *
 */
@Data
public class RestException {

    /**
     * Variable global  que se inicializa en el constructor
     */
    private HttpStatus status;

    /**
     * Variable global que se inicializa en el constructor
     */
    private String message;


    private final int statusCod;

    /**
     * Ese es el constructor de la clase
     * @param message
     * @param status
     * @param statusCod
     */
    public RestException(String message, HttpStatus status, int statusCod) {
        this.message = message;
        this.status = status;
        this.statusCod = statusCod;
    }
}

