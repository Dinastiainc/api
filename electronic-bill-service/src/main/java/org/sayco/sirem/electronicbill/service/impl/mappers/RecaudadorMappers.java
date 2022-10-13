package org.sayco.sirem.electronicbill.service.impl.mappers;

import org.mapstruct.Mapper;
import org.sayco.sirem.electronicbill.model.EmpresarioDTO;
import org.sayco.sirem.electronicbill.model.RecaudadorDTO;
import org.sayco.sirem.electronicbill.repository.entity.Empresario;
import org.sayco.sirem.electronicbill.repository.entity.Recaudador;

import java.util.List;

@Mapper(componentModel = "spring", config = IMapper.class)
public interface RecaudadorMappers extends IMapper<RecaudadorDTO, Recaudador> {

    RecaudadorDTO toDTO(Recaudador result);

    Recaudador toEntity(RecaudadorDTO result);

    List<RecaudadorDTO> toListDTO(List<Recaudador> results);
}
