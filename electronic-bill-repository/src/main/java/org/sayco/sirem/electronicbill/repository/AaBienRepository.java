package org.sayco.sirem.electronicbill.repository;

import org.sayco.sirem.electronicbill.repository.entity.AaBien;
import org.sayco.sirem.electronicbill.repository.entity.Tercero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * PRUEBA
 */
@Repository
public interface AaBienRepository extends CrudRepository<AaBien, Long> {
}
