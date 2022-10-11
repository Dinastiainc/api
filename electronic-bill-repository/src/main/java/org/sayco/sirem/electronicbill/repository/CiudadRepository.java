package org.sayco.sirem.electronicbill.repository;

import org.sayco.sirem.electronicbill.repository.entity.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface para la gestion de la data que interactua con la base de datos
 */
@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, String> {
    List<Ciudad> findByNombre(@Param("nombre") String nombre);

}
