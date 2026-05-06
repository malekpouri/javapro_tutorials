package ir.javapro.organization_service.repository;

import ir.javapro.organization_service.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization getOrganizationByOrganizationCode(String organizationCode);
}
