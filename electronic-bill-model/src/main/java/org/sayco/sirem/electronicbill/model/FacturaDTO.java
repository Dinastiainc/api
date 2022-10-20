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
     * Campo que representa el tipo de documento y viene quemado desde sirem con el valor FA
     */
    private String tipoDcto;

    /**
     *
     */
    private BigDecimal codigoDeIntegracion ;

    /**
     * Campo que representa el origen y viene quemado desde sirem con el valor FAC
     */
    private String origen ;

    /**
     * Campo que representa el codigo del vendedor este campos se buscara en la tabla VENDEN si existe se guardará
     * en las tablas MVTRADE y TRADE si el proceso no tiene ningun inconveniente
     */
    private String recaudador;

    /**
     * Nombre de la ciudad
     */
    private String ciudad;

    /**
     *
     */
    private String cuentaContable ;

    /**
     *
     */
    private String modalidadDeUso ;

    /**
     * Campo que representa el usuario
     */
    private String usuario;

    /**
     * Campo que representa el tipo
     */
    private String tipo;
}
