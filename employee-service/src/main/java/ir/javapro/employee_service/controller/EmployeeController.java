package ir.javapro.employee_service.controller;

import ir.javapro.employee_service.dto.APIResponseDto;
import ir.javapro.employee_service.dto.EmployeeRequestDto;
import ir.javapro.employee_service.dto.EmployeeResponseDto;
import ir.javapro.employee_service.model.Employee;
import ir.javapro.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
}
