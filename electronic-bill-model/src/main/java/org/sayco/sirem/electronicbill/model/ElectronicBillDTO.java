package org.sayco.sirem.electronicbill.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Este DTO encapsula la informacion de la factura electronica que viene desde el sistema externo (SIREM) o de la base
 * de datos de esta API
 */

@Data
public class ElectronicBillDTO {

    /**
     * Número del consecutivo (Consecutivo propio de la factura electronica) se crea cuando se alamcena en la base de
     * datos
     */
    private Long id;

    /**
     * Información del usuario
     */
    private UserDTO user;

    /**
     * Fecha de generación, se crea al guardar en la base de datos
     */
    private Date creationDate;

    /**
     * Parametrizar seleccionar fecha para radio
     */
    private Date expirationDate;

    /**
     * Forma de pago
     */
    private String wayPay;

    /**
     * Informaión de facturación
     */
    private BillingDTO billing;

    /**
     * Total Bruto
     */
    private BigDecimal grossTotal;

    /**
     * Impuesto Total
     */
    private BigDecimal taxTotal;

    /**
     * Total Neto
     */
    private BigDecimal netTotal;

    /**
     * Codigo de barras
     */
    private String barCode;

    /**
     * Fecha vencimiento del formato
     */
    private Date formatExpirationDate;
}
