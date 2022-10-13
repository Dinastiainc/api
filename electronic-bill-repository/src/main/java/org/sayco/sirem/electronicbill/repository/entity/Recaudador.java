package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Este objeto es guardado en la tabla VENDEN
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "VENDEN")
public class Recaudador {

    /**
     * Identificador
     */
    @Id
    @Column(name = "CODVEN")
    private String codigo;

    /**
     * Campo que representa el centro de cosotos
     */
    @Column(name = "CCOSTOS")
    private String centroDeCostos;

    /**
     * campo que representa el nombre del recaudador(a)
     */
    @Column(name = "NOMBRE")
    private String nombre;

    /**
     * campo que representa el telefono del recaudador(a)
     */
    @Column(name = "TEL")
    private String telefono;

    /**
     * Campo que representa la direccion del recaudador(a)
     */
    @Column(name = "DIRECCION")
    private String direccion;

    /**
     * Campo que representa el comentario del recaudador
     */
    @Column(name = "COMENTARIO")
    private String comentario;
}
