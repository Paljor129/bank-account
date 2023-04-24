package com.societegenerale.bankaccountsystem.controller.mapper;

import com.societegenerale.bankaccountsystem.controller.dto.RoleDto;
import com.societegenerale.bankaccountsystem.domain.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    public RoleDto mapToDto(Role entity) {
        RoleDto dto = new RoleDto();
        dto.setDescription(entity.getDescription());
        dto.setLabel(entity.getLabel());
        dto.setClient(entity.getClient());

        return dto;
    }

    public Role mapToEntity(RoleDto dto) {
        Role entity = new Role();
        entity.setDescription(dto.getDescription());
        entity.setLabel(dto.getLabel());
        entity.setClient(dto.getClient());

        return entity;
    }

    public List<RoleDto> mapToDtos(List<Role> roles) {
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role role : roles) {
            roleDtos.add(this.mapToDto(role));
        }
        return roleDtos;
    }

}
