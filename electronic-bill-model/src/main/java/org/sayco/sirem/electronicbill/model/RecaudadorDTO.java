package org.sayco.sirem.electronicbill.model;

import lombok.Data;

/**
 * Este DTO encapsula la informacion del Recaudador que viene desde el sistema externo (SIREM)
 */
@Data
public class RecaudadorDTO {

    /**
     * Identificador
     */
    private String codigo;

    /**
     * Campo que representa el centro de cosotos
     */
    private String centroDeCostos;

    /**
     * campo que representa el nombre del recaudador(a)
     */
    private String nombre;

    /**
     * campo que representa el telefono del recaudador(a)
     */
    private String telefono;

    /**
     * Campo que representa la direccion del recaudador(a)
     */
    private String direccion;

    /**
     * Campo que representa el comentario del recaudador
     */
    private String comentario;
}
