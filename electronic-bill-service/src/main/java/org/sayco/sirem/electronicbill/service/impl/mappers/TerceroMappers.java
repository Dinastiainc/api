package org.sayco.sirem.electronicbill.service.impl.mappers;

import org.mapstruct.Mapper;
import org.sayco.sirem.electronicbill.model.TerceroDTO;
import org.sayco.sirem.electronicbill.repository.entity.Tercero;

import java.util.List;

@Mapper(componentModel = "spring", config = IMapper.class)
public interface TerceroMappers extends IMapper<TerceroDTO, Tercero> {

    TerceroDTO toDTO(Tercero result);

    Tercero toEntity(TerceroDTO result);

    List<TerceroDTO> toListDTO(List<Tercero> results);
}
