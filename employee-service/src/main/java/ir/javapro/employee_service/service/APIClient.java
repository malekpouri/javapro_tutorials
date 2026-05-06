package ir.javapro.employee_service.service;

import ir.javapro.employee_service.dto.DepartmentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/department/{department-code}")
    DepartmentResponseDto getDepartment(@PathVariable("department-code") String departmentCode);
}
