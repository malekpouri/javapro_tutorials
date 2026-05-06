package ir.javapro.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    private DepartmentResponseDto department;
    private EmployeeResponseDto employee;
    private OrganizationDto organization;
}
