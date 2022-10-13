package org.sayco.sirem.electronicbill.service.impl.mappers;

import org.mapstruct.Mapper;
import org.sayco.sirem.electronicbill.model.CiudadDTO;
import org.sayco.sirem.electronicbill.model.EmpresarioDTO;
import org.sayco.sirem.electronicbill.repository.entity.Ciudad;
import org.sayco.sirem.electronicbill.repository.entity.Empresario;

import java.util.List;

@Mapper(componentModel = "spring", config = IMapper.class)
public interface CiudadMappers extends IMapper<CiudadDTO, Ciudad> {

    CiudadDTO toDTO(Ciudad result);

    Ciudad toEntity(CiudadDTO result);

    List<CiudadDTO> toListDTO(List<Ciudad> results);
}
