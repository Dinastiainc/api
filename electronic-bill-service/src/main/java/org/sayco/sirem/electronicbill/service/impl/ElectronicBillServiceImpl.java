package org.sayco.sirem.electronicbill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.springframework.stereotype.Service;

/**
 * Esta clase es la que se comunica con el modulo de repositorio ya sea para consultar, crear, eliminar
 * o alterar registros de la factura electronica
 */
@Slf4j
@Service
public class ElectronicBillServiceImpl implements ElectronicBillService {

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar la factura electronica
     * @param electronicBillDTO
     * @return ElectronicBillDTO
     */
    @Override
    public ElectronicBillDTO save(ElectronicBillDTO electronicBillDTO) {
        return electronicBillDTO;
    }
}
