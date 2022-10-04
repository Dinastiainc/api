package org.sayco.sirem.electronicbill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;
import org.sayco.sirem.electronicbill.repository.AaBienRepository;
import org.sayco.sirem.electronicbill.repository.TerceroRepository;
import org.sayco.sirem.electronicbill.repository.entity.AaBien;
import org.sayco.sirem.electronicbill.repository.entity.Tercero;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.sayco.sirem.electronicbill.service.impl.mappers.AaBienMappers;
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
     * PRUEBA
     */
    @Autowired
    private AaBienRepository aaBienRepository;

    /**
     * Variable global que se encarga de inyectar el mapper de los objetos Tercero a TerceroDTO y viceversa
     */
    @Autowired
    private TerceroMappers terceroMappers;


    /**
     * PRUEBA
     */
    @Autowired
    private AaBienMappers aaBienMappers;

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar la factura electronica
     *
     * @param electronicBillDTO
     * @return ElectronicBillDTO
     */
    /**
    @Override
    public ElectronicBillDTO save(ElectronicBillDTO electronicBillDTO) {
        try {
            Tercero terceroPRUEBA = terceroRepository.findByNit("0107917559").get();
            Tercero terceroTmp = terceroMappers.toEntity(electronicBillDTO.getTercero());
            terceroRepository.save(terceroTmp);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo guardar terceros");
        }
        return electronicBillDTO;
    }
    */

    public ElectronicBillDTO save(ElectronicBillDTO electronicBillDTO) {
        try {
            AaBien aaBien = aaBienMappers.toEntity(electronicBillDTO.getAaBien());
            aaBienRepository.save(aaBien);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo guardar AaBien");
        }
        return electronicBillDTO;
    }
}
