package org.sayco.sirem.electronicbill.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase que se encarga de almacenar y entregar todo lo que tenga que ver con los atributos de la clave compuesta del
 * objeto trade
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Embeddable
public class TradePk implements Serializable {

    /**
     * Identificador compuesto del objeto Trade y representa el número de la factura
     */
    @Column(name = "NRODCTO")
    private String nroDcto;

    /**
     * Identificador compuesto del objeto Trade
     */
    @Column(name = "ORIGEN")
    private String origen;

    /**
     * Identificador compuesto del objeto Trade
     */
    @Column(name = "TIPODCTO")
    private String tipoDcto;
}
