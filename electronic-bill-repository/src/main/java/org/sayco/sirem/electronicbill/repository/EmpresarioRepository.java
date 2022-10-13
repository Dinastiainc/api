package org.sayco.sirem.electronicbill.repository;

import org.sayco.sirem.electronicbill.repository.entity.Empresario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para la gestion de la data que interactua con la base de datos
 */
@Repository
public interface EmpresarioRepository extends CrudRepository<Empresario, String> {
}
