package com.example.accesskeybackend.template.mapper;

import com.example.accesskeybackend.template.dto.IPv6SupportResultDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IPv6SupportMapper {
    @Mapping(target = "success", source = "checkResult", defaultValue = "false")
    IPv6SupportResultDto toDto(Boolean checkResult);
}