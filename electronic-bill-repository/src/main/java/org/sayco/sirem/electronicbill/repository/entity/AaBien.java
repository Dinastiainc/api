package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Clase que sirve para prueba de conexion
 */

@NoArgsConstructor
@Entity
@Data
@Table(name = "AA_BIEN")
public class AaBien {

    @Id
    @Column(name = "nrodcto")
    String numDocumento;

    @Column(name = "unit")
    BigDecimal unidad;

}
