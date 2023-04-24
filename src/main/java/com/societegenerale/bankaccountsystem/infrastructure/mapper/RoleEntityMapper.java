/*
package com.societegenerale.bankaccountsystem.infrastructure.mapper;

import com.societegenerale.bankaccountsystem.domain.model.Role;
import com.societegenerale.bankaccountsystem.domain.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleEntityMapper {

    private final ClientEntityMapper clientEntityMapper;

    public RoleEntityMapper(ClientEntityMapper clientEntityMapper) {
        this.clientEntityMapper = clientEntityMapper;
    }

    public Role toRole(RoleEntity roleEntity) {
        Role role = new Role();
        role.setDescription(roleEntity.getDescription());
        role.setLabel(roleEntity.getLabel());
        role.setClient(clientEntityMapper.toClient(roleEntity.getClientEntity()));

        return role;
    };

    public RoleEntity toRoleEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setDescription(role.getDescription());
        roleEntity.setLabel(role.getLabel());
        roleEntity.setClientEntity(clientEntityMapper.toClientEntity(role.getClient()));

        return roleEntity;
    };

    public List<Role> toRoles(List<RoleEntity> roleEntities) {
        List<Role> roles = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            roles.add(this.toRole(roleEntity));
        }
        return roles;
    }

    public List<RoleEntity> toRoleEntities(List<Role> roles) {
        List<RoleEntity> roleEntities = new ArrayList<>();
        for (Role role : roles) {
            roleEntities.add(this.toRoleEntity(role));
        }
        return roleEntities;
    }

}
*/
