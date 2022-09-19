package org.sayco.sirem.electronicbill.service;


import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;

public interface ElectronicBillService {

    /**
     * Este metodo es implementado desde la clase que necesita guardar la factura electronica en la base de datos
     * @param electronicBillDTO
     * @return ElectronicBillDTO
     */
    ElectronicBillDTO save (ElectronicBillDTO electronicBillDTO);
}
