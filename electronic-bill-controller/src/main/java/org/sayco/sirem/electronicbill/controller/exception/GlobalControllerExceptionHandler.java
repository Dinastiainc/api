package org.sayco.sirem.electronicbill.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

/**
 * Clase control de excepciones del sistema
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {
    public static final String ERROR_AL_REALIZAR_LA_OPERACION = "Error al realizar la operación";


    /**
     * variable para activar el debug
     */
    private boolean debug = true;

    /**
     * Este metodo se encarga de mostrar la excepcion por defecto
     *
     * @param e
     * @return ResponseEntity<RestException>
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<RestException> defaultErrorHandler(Exception e) throws Exception {
        log.error(e.getMessage(), e);
        String err = e.getMessage();
        err = Optional.ofNullable(err).orElse(ERROR_AL_REALIZAR_LA_OPERACION);
        if (err.isEmpty()) {
            err = ERROR_AL_REALIZAR_LA_OPERACION;
        }
        RestException commonsEx = new RestException(debug ? getDebugInfo(e) : err, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(commonsEx, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Este metodo muestra la traza del debug
     * @param e
     * @return String
     */
    private String getDebugInfo(Exception e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getMessage());
        stringBuilder.append(":");
        stringBuilder.append(e.toString());
        stringBuilder.append(":");
        stringBuilder.append(e.getCause() != null ? e.getCause().getMessage() : "");
        stringBuilder.append(":");
        stringBuilder.append(ExceptionUtils.getStackTrace(e));
        return stringBuilder.toString();
    }
}
