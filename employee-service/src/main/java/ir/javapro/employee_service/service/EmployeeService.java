package ir.javapro.employee_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import ir.javapro.employee_service.dto.*;
import ir.javapro.employee_service.model.Employee;
import ir.javapro.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final Logger log = LoggerFactory.getLogger(EmployeeService.class);
//    private final APIClient apiClient;
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee(
                null,
                employeeRequestDto.getFirstName(),
                employeeRequestDto.getLastName(),
                employeeRequestDto.getEmail(),
                employeeRequestDto.getDepartmentCode(),
                employeeRequestDto.getOrganizationCode()
        );

        Employee save = employeeRepository.save(employee);
        return new EmployeeResponseDto(
                save.getId(),
                save.getFirstName(),
                save.getLastName(),
                save.getEmail(),
                save.getDepartmentCode(),
                save.getOrganizationCode()
        );
    }


//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long id) {

        log.info("inside getEmployeeById method");

        Employee employee = employeeRepository.findById(id).get();

        String departmentCode = employee.getDepartmentCode();

//        ResponseEntity<DepartmentResponseDto> reponse= restTemplate.getForEntity("http://localhost:8080/api/department/" + departmentCode, DepartmentResponseDto.class);


        DepartmentResponseDto department = webClient.get()
                .uri(("http://localhost:8080/api/department/" + departmentCode))
                .retrieve()
                .bodyToMono(DepartmentResponseDto.class)
                .block();
//        DepartmentResponseDto department = apiClient.getDepartment(departmentCode);

        String organizationCode = employee.getOrganizationCode();
        OrganizationDto organization = webClient.get()
                .uri(("http://localhost:8083/api/organization/" + organizationCode))
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();


        APIResponseDto responseDto = new APIResponseDto();
        responseDto.setDepartment(department);
        responseDto.setOrganization(organization);
        responseDto.setEmployee(new EmployeeResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        ));

        return responseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id,Exception exception) {
        Employee employee = employeeRepository.findById(id).get();

        log.info("inside getDefaultDepartment method");

        DepartmentResponseDto department=new DepartmentResponseDto();
        department.setDepartmentCode("AI001");
        department.setDepartmentName("AI Department 1");
        department.setDepartmentDescription("AI Department Description");

        APIResponseDto responseDto = new APIResponseDto();
        responseDto.setDepartment(department);
        responseDto.setEmployee(new EmployeeResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        ));

        return responseDto;
    }
}
