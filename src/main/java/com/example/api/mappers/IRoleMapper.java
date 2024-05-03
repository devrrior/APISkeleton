package com.example.api.mappers;

import com.example.api.persistance.entities.projections.IRoleProjection;
import com.example.api.web.dtos.responses.GetRoleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
    GetRoleResponse toGetRoleResponse(IRoleProjection roleProjection);
}
