package org.sayco.sirem.electronicbill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sayco.sirem.electronicbill.model.CiudadDTO;
import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;
import org.sayco.sirem.electronicbill.model.TerceroDTO;
import org.sayco.sirem.electronicbill.repository.CiudadRepository;
import org.sayco.sirem.electronicbill.repository.TerceroRepository;
import org.sayco.sirem.electronicbill.repository.entity.Ciudad;
import org.sayco.sirem.electronicbill.repository.entity.Tercero;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.sayco.sirem.electronicbill.service.impl.mappers.CiudadMappers;
import org.sayco.sirem.electronicbill.service.impl.mappers.TerceroMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
     * Esta variable es la encargada de mapear el objeto Ciudad a CiudadDTO y viceversa
     */
    @Autowired
    private CiudadMappers ciudadMappers;

    /**
     * Variable global que se encarga de inyectar el repository TerceroRepository  para interactuar con el
     * modulo repository
     */
    @Autowired
    private CiudadRepository ciudadRepository;

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar la factura electronica
     *
     * @param electronicBillDTO
     * @return ElectronicBillDTO
     */
    @Override
    public ElectronicBillDTO save(ElectronicBillDTO electronicBillDTO) {
        try{
            List<CiudadDTO> ciudades = findCityByName(electronicBillDTO.getCiudad());
            electronicBillDTO.getTercero().setCiudad(ciudades.get(0).getCod());
            TerceroDTO tercero = saveTercero(electronicBillDTO.getTercero());
            return electronicBillDTO;
        }catch(Exception e){
            throw new IllegalArgumentException(String.format("No se pudo guardar la factura electronica"), e);
        }
    }

    /**
     * Metodo que llama al repositorio para que le devuelva una lista de ciudades que se busca por el nombre
     * @return
     */
    private List<CiudadDTO> findCityByName (String nombreCiudad) {
        try{
            List<Ciudad> ciudades = ciudadRepository.findByNombre(nombreCiudad);
            return ciudadMappers.toListDTO(ciudades);
        }catch(Exception e){
            throw new IllegalArgumentException(String.format("No se pudo encontrar la ciudad con este nombre %s.", nombreCiudad), e);
        }
    }

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar tercero
     */
    private TerceroDTO saveTercero(TerceroDTO tercero) {
        try {
            Tercero terceroTmp = terceroMappers.toEntity(tercero);
            return terceroMappers.toDTO(terceroRepository.save(terceroTmp));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("No se pudo guardar terceros"), e);
        }
    }

}

