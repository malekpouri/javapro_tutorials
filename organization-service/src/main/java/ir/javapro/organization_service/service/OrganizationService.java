package ir.javapro.organization_service.service;

import ir.javapro.organization_service.dto.OrganizationDto;
import ir.javapro.organization_service.entity.Organization;
import ir.javapro.organization_service.mapper.OrganizationMapper;
import ir.javapro.organization_service.repository.OrganizationRepository;
import ir.javapro.organization_service.service.inter.OrganizationServiceInt;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationService implements OrganizationServiceInt {
    private final OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization entity = OrganizationMapper.toEntity(organizationDto);
        entity = organizationRepository.save(entity);
        return OrganizationMapper.toDto(entity);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.getOrganizationByOrganizationCode(organizationCode);
        return OrganizationMapper.toDto(organization);
    }
}
