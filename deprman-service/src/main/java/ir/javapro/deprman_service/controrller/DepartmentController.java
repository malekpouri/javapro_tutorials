package ir.javapro.deprman_service.controrller;

import ir.javapro.deprman_service.dto.DepartmentRequestDto;
import ir.javapro.deprman_service.dto.DepartmentResponseDto;
import ir.javapro.deprman_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentResponseDto> addDepartment(@RequestBody DepartmentRequestDto department) {
        DepartmentResponseDto department1 = departmentService.createDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentResponseDto> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentResponseDto department = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
