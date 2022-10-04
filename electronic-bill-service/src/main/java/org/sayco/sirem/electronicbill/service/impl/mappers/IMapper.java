package org.sayco.sirem.electronicbill.service.impl.mappers;


import org.mapstruct.*;
import java.util.List;

@MapperConfig(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMapper<V, E> {

    /**
     * Este metodo se encarga de solicitar tablero
     *
     * @param dominio dominio
     * @return V
     */
    V toDTO(E dominio);

    /**
     * Este metodo se encarga de solicitar los tableros
     *
     * @param dominio dominio
     * @return List<V>
     */
    List<V> toDTOs(List<E> dominio);

    /**
     * Este metodo se encarga de solicitar el modelo del tablero
     *
     * @param dominio dominio
     * @return E
     */
    E toEntity(V dominio);

    /**
     * Este metodo se encarga de solicitar los modelos del tablero
     *
     * @param dominio dominio
     * @return List<E>
     */
    List<E> toEntities(List<V> dominio);

}
