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
     * Nombre completo del tercero
     */
    private String nombre;

    /**
     * El primer nombre del tercero
     */
    private String nombre1;

    /**
     * Primer apellido1
     */
    private String apellido1;

    /**
     * Primer apellido2
     */
    private String apellido2;

    /**
     * Código de la ciudad
     */
    private String ciudad;

    /**
     * Código postal
     */
    private String codigoPostal;

    /**
     * direccion
     */
    private String direccion;

    /**
     * correo
     */
    private String email;

    /**
     * Fecha de ingreso o creación
     */
    private Date fechaIngreso;
}
