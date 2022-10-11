package org.sayco.sirem.electronicbill.model;

import lombok.Data;

/**
 * Este DTO encapsula la informacion de la ciudad que viene desde el sistema externo (SIREM) o de la base
 * de datos de esta API
 */
@Data
public class CiudadDTO {

    /**
     * Número de identificación de la ciudad
     */
    private String cod;

    /**
     * Nombre de la ciudad
     */
    private String nombre;
}
