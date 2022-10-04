package org.sayco.sirem.electronicbill.model;

import lombok.Data;

import java.util.Date;

/**
 * Este DTO encapsula la informacion de terceros que viene desde el sistema externo (SIREM)
 */
@Data
public class TerceroDTO {

    /**
     * Número de identificación de terceros
     */
    private String nit;

    /**
     * Detalle
     */
    private String detalle;

    /**
     * Nombre del banco
     */
    private String nombreBanco;

    /**
     * email cartera
     */
    private String emailCartera;

    /**
     * email factura electronica
     */
    private String emailFacturaElectronica;

    /**
     *
     */
    private String nitExterio;

    /**
     * Coódigo unico que identifica la entidad en SGS
     */
    private String entidad;

    private String clavePago;//3

    private String  cdusocfdi;  //10

    private String complecfdi; //250

    private String emailCxp; //250

    private int habilProv; //1

    private int plazoJusto; //1

    private int regtrsimo; //1

    private String codRegFis; //5

    private int comelectro; // 1

     private String medPag; //5

}
