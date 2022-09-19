package org.sayco.sirem.electronicbill.model;

import lombok.Data;

/**
 * Este DTO encapsula la informacion del usuario que viene desde el sistema externo (SIREM) o de la base
 * de datos de esta API
 */
@Data
public class UserDTO {

    /**
     * Nombre del usuario
     */
    private String name;

    /**
     * Número de identificación tributaria
     */
    private String nit;

    /**
     * Dirección de donde vive el usuario
     */
    private String address;

    /**
     * Correo electronico del usuario
     */
    private String email;

    /**
     * Ciudad donde vive el usuario
     */
    private String city;

    /**
     * Zona de recaudo del Usuario
     */
    private String collectionArea;

}
