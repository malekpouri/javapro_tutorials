package ir.javapro.springrestapi.controller;

import ir.javapro.springrestapi.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    List<User> students=new ArrayList<>();

    public StudentController() {
        students.add(new User(1L,"ali","rezayee1"));
        students.add(new User(2L,"mohammad","rezayee2"));
        students.add(new User(3L,"mahmod","rezayee3"));
        students.add(new User(4L,"reza","rezayee4"));
        students.add(new User(5L,"javad","rezayee5"));
    }
    @GetMapping
    public ResponseEntity<List<User>> get_All(){
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> get_by_id(@PathVariable Long id){
        for (User student:students){
            if (student.getId().equals(id)){
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<HttpStatus> create_student(@RequestBody User newStudent){
        for (User student:students){
            if (student.getId().equals(newStudent.getId())){
                return ResponseEntity.badRequest().build();
            }
        }
        students.add(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update_student(@PathVariable Long id,
                                                     @RequestBody User updateStudent){
        int index=-1;
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)) {
                index = i;
                break;
            };
        }
        if (index==-1){
            return ResponseEntity.notFound().build();
        }
        User existingStudent=students.get(index);
        existingStudent.setFirstName(updateStudent.getFirstName());
        existingStudent.setLastName(updateStudent.getLastName());
        students.set(index,existingStudent);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete_user(@PathVariable Long id){
        int index=-1;
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)) {
                index = i;
                break;
            };
        }
        if (index==-1){
            return ResponseEntity.notFound().build();
        }
        students.remove(index);
        return ResponseEntity.ok().build();
    }
}
