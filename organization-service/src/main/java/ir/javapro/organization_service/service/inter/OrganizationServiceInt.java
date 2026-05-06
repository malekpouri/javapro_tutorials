package ir.javapro.organization_service.service.inter;

import ir.javapro.organization_service.dto.OrganizationDto;

public interface OrganizationServiceInt {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);
}
