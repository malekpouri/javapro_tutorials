package ir.javapro.organization_service.mapper;

import ir.javapro.organization_service.dto.OrganizationDto;
import ir.javapro.organization_service.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto toDto(Organization organization) {

        return new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreateDate()
        );
    }
    public static Organization toEntity(OrganizationDto organizationDto) {

        return new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreateDate()
        );
    }
}
