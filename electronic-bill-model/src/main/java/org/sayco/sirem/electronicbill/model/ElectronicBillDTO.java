package org.sayco.sirem.electronicbill.model;

import lombok.Data;

/**
 * Este DTO encapsula la informacion de la factura electronica que viene desde el sistema externo (SIREM) o de la base
 * de datos de esta API
 */

@Data
public class ElectronicBillDTO {


    /**
     * Información de tercero
     */
    private TerceroDTO tercero;

    /**
     * Información de la factura
     */
    private FacturaDTO factura;
}
