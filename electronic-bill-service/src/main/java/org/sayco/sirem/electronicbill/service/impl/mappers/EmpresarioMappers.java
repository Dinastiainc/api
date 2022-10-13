package org.sayco.sirem.electronicbill.service.impl.mappers;

import org.mapstruct.Mapper;
import org.sayco.sirem.electronicbill.model.EmpresarioDTO;
import org.sayco.sirem.electronicbill.repository.entity.Empresario;

import java.util.List;

@Mapper(componentModel = "spring", config = IMapper.class)
public interface EmpresarioMappers extends IMapper<EmpresarioDTO, Empresario> {

    EmpresarioDTO toDTO(Empresario result);

    Empresario toEntity(EmpresarioDTO result);

    List<EmpresarioDTO> toListDTO(List<Empresario> results);
}
