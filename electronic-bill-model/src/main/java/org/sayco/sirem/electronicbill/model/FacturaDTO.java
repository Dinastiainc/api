package org.sayco.sirem.electronicbill.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Este DTO encapsula la informacion de la factura que viene desde el sistema externo (SIREM)
 */
@Data
public class FacturaDTO {

    /**
     * Número de identificación de Empresarios
     */
    private String nit;

    /**
     * campo que representa el nombre del evento y se mapea con los campos nombre y nota en la tabla MVTRADE
     */
    private String nombreDelEvento;

    /**
     * Campo que representa el detalle
     */
    private String establecimiento;

    /**
     * Campo que representa el valor bruto, valor de la unidad y valor de la venta
     */
    private BigDecimal valorDeLicencia;

    /**
     * Número de la licencia
     */
    private String numeroDeLicencia;

    /**
     * Número de la factura
     */
    private String numeroDeFactura;

    /**
     * Fecha del evento
     */
    private Date fechaEvento;

    /**
     * Fecha de la factura
     */
    private Date fechaFactura;

    /**
     * Fecha del pago
     */
    private Date fechaPago;

    /**
     * Es el codigo de centros de costo y e guarda en las tablas de TRADE y MVTRADE en la columna CODCC
     */
    private String centroDeCostos;

    /**
     * Campo que representa el origen
     */
    private String origen;

    /**
     * Campo que representa el tipo de documento
     */
    private String tipoDcto;

    /**
     * Campo que representa el Id de la tabla MTMERCIA
     */
    private String producto;
}
