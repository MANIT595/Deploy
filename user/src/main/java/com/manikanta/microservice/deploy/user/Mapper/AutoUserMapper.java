package com.manikanta.microservice.deploy.user.Mapper;
import com.manikanta.microservice.deploy.user.DTO.UserDTO;
import com.manikanta.microservice.deploy.user.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDTO mapToDTO(User user);
}
