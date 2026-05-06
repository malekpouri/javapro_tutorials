package ir.javapro.deprman_service.service;

import ir.javapro.deprman_service.dto.DepartmentRequestDto;
import ir.javapro.deprman_service.dto.DepartmentResponseDto;
import ir.javapro.deprman_service.model.Department;
import ir.javapro.deprman_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = new Department(
                null,
                departmentRequestDto.getDepartmentName(),
                departmentRequestDto.getDepartmentDescription(),
                departmentRequestDto.getDepartmentCode()
        );
        Department save = departmentRepository.save(department);
        return new DepartmentResponseDto(
                save.getId(),
                save.getDepartmentName(),
                save.getDepartmentDescription(),
                save.getDepartmentCode()
        );


    }

    public DepartmentResponseDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return new DepartmentResponseDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

    }
}
