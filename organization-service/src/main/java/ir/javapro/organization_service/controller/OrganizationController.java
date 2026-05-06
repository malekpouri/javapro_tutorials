package ir.javapro.organization_service.controller;

import ir.javapro.organization_service.dto.OrganizationDto;
import ir.javapro.organization_service.entity.Organization;
import ir.javapro.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organization) {
        OrganizationDto organizationDto = organizationService.saveOrganization(organization);
        return new ResponseEntity<>(organizationDto, HttpStatus.CREATED);
    }
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable String code) {
        OrganizationDto organization = organizationService.getOrganizationByCode(code);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }
}
