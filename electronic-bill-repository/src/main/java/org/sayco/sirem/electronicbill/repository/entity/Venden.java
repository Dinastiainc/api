package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que esta relacionada con la tabla VENDEN que es para el proceso de traer el registro que esta amarrado a la
 * tabla TRADE y MVTRADE
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "VENDEN")
public class Venden {

    /**
     * Número de identificación de vendedor
     */
    @Id
    @Column(name = "CODVEN")
    private String recaudador;
}
