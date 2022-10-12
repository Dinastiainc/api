package org.sayco.sirem.electronicbill.service.exception;

/**
 * La interfaz se encarga de adminstrar las excepciones
 */
public class ServiceException extends RuntimeException {

    /**
     * Este es el contructor de la classe y es encargado de mostrar el mensaje cuando ocurra esta excepcion
     * @param message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Este es el contructor de la classe y es encargado de mostrar el mensaje cuando ocurra esta excepcion
     * @param message
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
