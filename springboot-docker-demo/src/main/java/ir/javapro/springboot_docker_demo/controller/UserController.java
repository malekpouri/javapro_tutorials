package ir.javapro.springboot_docker_demo.controller;

import ir.javapro.springboot_docker_demo.entity.User;
import ir.javapro.springboot_docker_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    // create new user
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }
    // http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
