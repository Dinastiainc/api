package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que esta relacionada con la tabla CUENTAS que es para el proceso de traer el registro que esta amarrado a la
 * tabla TRADE
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "CUENTAS")
public class Cuentas {

    /**
     * Número de identificación de la cuenta
     */
    @Id
    @Column(name = "CODIGOCTA")
    private String codigoCuenta;
}
