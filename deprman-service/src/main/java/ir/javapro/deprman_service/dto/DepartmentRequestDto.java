package ir.javapro.deprman_service.dto;

import lombok.Data;

@Data
public class DepartmentRequestDto {
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
