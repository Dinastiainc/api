package org.sayco.sirem.electronicbill.repository;

import java.util.List;

import org.sayco.sirem.electronicbill.repository.entity.ClieRespFiscal;
import org.sayco.sirem.electronicbill.repository.entity.Venden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para la gestion de la data que interactua con la base de datos
 */
@Repository
public interface ClientRespRepository extends CrudRepository<ClieRespFiscal, String> {
    List<ClieRespFiscal> findByNit(String nit);
}
