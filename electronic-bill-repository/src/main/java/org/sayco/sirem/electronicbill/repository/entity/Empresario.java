package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

/**
 * Clase que est relacionada con la tabla MTPROCLI que es para el proceso de Empresarios que integra al ERP los valores
 * contenidos en los campos que se detallan a continuacion
 */

@NoArgsConstructor
@Entity
@Data
@Table(name = "MTPROCLI")
public class Empresario {

    /**
     * Número de identificación de Empresarios
     */
    @Id
    @Column(name = "NIT")
    private String nit;

    /**
     * Nombre completo del Empresario
     */
    @Column(name = "NOMBRE")
    private String nombre;

    /**
     * El primer nombre del Empresario
     */
    @Column(name = "NOMBRE1")
    private String nombre1;

    /**
     * Primer apellido1
     */
    @Column(name = "APELLIDO1")
    private String apellido1;

    /**
     * Primer apellido2
     */
    @Column(name = "APELLIDO2")
    private String apellido2;

    /**
     * Código de la ciudad
     */
    @Column(name = "CIUDAD")
    private String ciudad;

    /**
     * Código postal
     */
    @Column(name = "CODPOSTAL")
    private String codigoPostal;

    /**
     * direccion
     */
    @Column(name = "DIRECCION")
    private String direccion;

    /**
     * correo
     */
    @Column(name = "EMAIL")
    private String  email;

    /**
     * Nombre de la ciudad
     */
    @Column(name = "CIUDADPRV ")
    private String ciudadPrv;

    /**
     * Correo de cartera
     */
    @Column(name = "EMAILCAR")
    private String emailCartera;

    /**
     * Correo de cuenta por pagar
     */
    @Column(name = "EMAILCXP")
    private String emailCuentaPorPagar;

    /**
     * Correo de reseccion de factura electronica
     */
    @Column(name = "EMAILFEC")
    private String emailReseccionFacElec;

    /**
     * Fecha de ingreso del registro
     */
    @Column(name = "FECING")
    private Date fechaRegistroCliente;

    /**
     * Fecha cuando se modifica el registro
     */
    @Column(name = "FECMOD")
    private Date fechaModificacion;

    /**
     * telefono 1
     */
    @Column(name = "TEL1")
    private String telefono1;

    /**
     * telefono 2
     */
    @Column(name = "TEL2")
    private String telefono2;

    /**
     * Correo del proveedor
     */
    @Column(name = "EMAILP")
    private String emailProveedor;

    /**
     * segundo Nombre (persona natural)
     */
    @Column(name = "NOMBRE2")
    private String nombre2;


    /**
     * Fecha de ingreso o creación
     */
    @Column(name = "FECHAING")
    private Date fechaIngreso;
}
