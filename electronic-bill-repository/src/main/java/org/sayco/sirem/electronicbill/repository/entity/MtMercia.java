package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que esta relacionada con la tabla MTMERCIA que es para el proceso de traer el registro que se relacionan con el
 * atributo cuentaContable del request
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "MTMERCIA")
public class MtMercia {

    /**
     * Número de identificación de ...
     */
    @Id
    @Column(name = "CODIGO")
    private String codigo;
}
