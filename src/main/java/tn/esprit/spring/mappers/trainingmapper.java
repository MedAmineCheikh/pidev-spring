package tn.esprit.spring.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tn.esprit.spring.dto.updatetrainingdto;
import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.Training;

@Mapper(componentModel = "spring")
public interface trainingmapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainFromDto(updatetrainingdto dto, @MappingTarget Training entity);
}
