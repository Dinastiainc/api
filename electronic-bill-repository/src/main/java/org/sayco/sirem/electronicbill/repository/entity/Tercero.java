package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

/**
 * Clase que est relacionada con la tabla MTPROCLI que es para el proceso de terceros que integra al ERP los valores
 * contenidos en los campos que se detallan a continuacion
 */

@NoArgsConstructor
@Entity
@Data
@Table(name = "MTPROCLI")
public class Tercero {

    /**
     * Número de identificación de terceros
     */
    @Id
    @Column(name = "NIT")
    String nit;

    /**
     * Nombre completo del tercero
     */
    @Column(name = "NOMBRE")
    String nombre;

    /**
     * El primer nombre del tercero
     */
    @Column(name = "NOMBRE1")
    String nombre1;

    /**
     * Primer apellido1
     */
    @Column(name = "APELLIDO1")
    String apellido1;

    /**
     * Primer apellido2
     */
    @Column(name = "APELLIDO2")
    String apellido2;

    /**
     * Código de la ciudad
     */
    @Column(name = "CIUDAD")
    String ciudad;

    /**
     * Código postal
     */
    @Column(name = "CODPOSTAL")
    String codigoPostal;

    /**
     * direccion
     */
    @Column(name = "DIRECCION")
     String direccion;

    /**
     * correo
     */
    @Column(name = "EMAIL")
     String  email;

    /**
     * Fecha de ingreso o creación
     */
    @Column(name = "FECHAING")
     Date fechaIngreso;
}
