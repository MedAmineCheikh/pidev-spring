package tn.esprit.spring.mappers;

import org.hibernate.hql.internal.ast.tree.UpdateStatement;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tn.esprit.spring.dto.updatecertifcatdto;
import tn.esprit.spring.entities.Certificat;

@Mapper(componentModel = "spring")
public interface certififcatmapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCertifiFromDto(updatecertifcatdto dto, @MappingTarget Certificat entity);
}
