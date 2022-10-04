package org.sayco.sirem.electronicbill.service.impl.mappers;

import org.mapstruct.Mapper;
import org.sayco.sirem.electronicbill.model.AaBienDTO;
import org.sayco.sirem.electronicbill.model.TerceroDTO;
import org.sayco.sirem.electronicbill.repository.entity.AaBien;
import org.sayco.sirem.electronicbill.repository.entity.Tercero;

import java.util.List;

@Mapper(componentModel = "spring", config = IMapper.class)
public interface AaBienMappers extends IMapper<AaBienDTO, AaBien> {

    AaBienDTO toDTO(AaBien aaBien);

    AaBien toEntity(AaBienDTO aaBien);

    List<AaBienDTO> toListDTO(List<AaBien> result);
}
