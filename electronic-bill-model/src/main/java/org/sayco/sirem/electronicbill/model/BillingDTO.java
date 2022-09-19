package org.sayco.sirem.electronicbill.model;

import lombok.Data;

import java.util.Date;

/**
 * Este DTO encapsula la informacion de la facturación que viene desde el sistema externo (SIREM) o de la base
 * de datos de esta API
 */
@Data
public class BillingDTO {

    /**
     * Fecha de inicio de la vigencia  de la licencia
     */
    private Date startDateValidityLicense;

    /**
     * Fecha fin de la vigencia  de la licencia
     */
    private Date endDateValidityLicense;

    /**
     * Número de autorización o licencia
     */
    private Long licenseAuthorizationNumber;

    /**
     * Descripción del evento
     */
    private String eventDescription;
}
