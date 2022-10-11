package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que esta relacionada con la tabla CIUDAD que pertenece terceros (MTPROCLI)
 */
@NoArgsConstructor
@Entity
@Data
@Table(name = "CIUDAD")
public class Ciudad {

    /**
     * Número de identificación de la ciudad
     */
    @Id
    @Column(name = "CODCIUDAD", nullable = false, length = 5)
    private String cod;

    /**
     * Nombre de la ciudad
     */
    @Column(name = "NOMBRE", length = 60)
    private String nombre;
}
