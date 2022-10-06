package org.sayco.sirem.electronicbill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;
import org.sayco.sirem.electronicbill.repository.TerceroRepository;
import org.sayco.sirem.electronicbill.repository.entity.Tercero;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.sayco.sirem.electronicbill.service.impl.mappers.TerceroMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es la que se comunica con el modulo de repositorio ya sea para consultar, crear, eliminar
 * o alterar registros de la factura electronica
 */
@Slf4j
@Service
public class ElectronicBillServiceImpl implements ElectronicBillService {

    /**
     * Variable global que se encarga de inyectar el repository TerceroRepository  para interactuar con el
     * modulo repository
     */
    @Autowired
    private TerceroRepository terceroRepository;

    /**
     * Esta variable es la encargada de mapear el objeto Tercero a TerceroDTO y viceversa
     */
    @Autowired
    private TerceroMappers terceroMappers;

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar la factura electronica
     *
     * @param electronicBillDTO
     * @return ElectronicBillDTO
     */

    @Override
    public ElectronicBillDTO save(ElectronicBillDTO electronicBillDTO) {
        try {
            Tercero terceroTmp = terceroMappers.toEntity(electronicBillDTO.getTercero());
            terceroRepository.save(terceroTmp);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo guardar tercerosHIX");
        }
        return electronicBillDTO;
    }
}
