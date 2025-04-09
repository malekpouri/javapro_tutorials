package ir.javapro.springrestapi.controller;

import ir.javapro.springrestapi.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DefaultController {
    @GetMapping("/hi")
    public String get_home(){
        return "Hi Java Pro Students";
    }

    @GetMapping("/user")
    public User get_user(){
        User user= new User(
                10L,
                "Mohammad",
                "Malekpouri"
        );
        return user;
    }

    @GetMapping("/users")
    public List<User> get_users(){
        List<User> users=new ArrayList<>();
        User user1= new User(
                10L,
                "Mohammad",
                "Malekpouri"
        );
        User user2= new User(
                20L,
                "Ali",
                "Alipour"
        );
        User user3= new User(
                30L,
                "Javad",
                "Javadpour"
        );
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    // http://localhost:8080/userbyid/1

    @GetMapping("/userbyid/{id}")
    public ResponseEntity<User> get_user_by_id(@PathVariable Long id){
        User user1= new User(
                10L,
                "Mohammad",
                "Malekpouri"
        );
        User user2= new User(
                20L,
                "Ali",
                "Alipour"
        );
        User user3= new User(
                30L,
                "Javad",
                "Javadpour"
        );
        if (id == 1L ){
            return ResponseEntity.ok(user1);
        } else if (id == 2L) {
            return ResponseEntity.ok(user2);
        } else if (id == 3L) {
            return ResponseEntity.ok(user3);
        }else return ResponseEntity.notFound().build();
    }
    @GetMapping("/userbynewid/{id}/{firstName}/{lastName}")
    public User get_user_by_new_id(
            @PathVariable Long id,
            @PathVariable String firstName,
            @PathVariable String lastName
    ){
        return new User(id,
                firstName,
                lastName);
    }
    // http://localhost:8080/usersquery?lastName=javaddi
    @GetMapping("/userbyquery")
    public User get_by_query(
            @RequestParam(required = true) Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        System.out.println(id);
        System.out.println(firstName);
        System.out.println(lastName);
        return null;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create_user(@RequestBody User user){
        return new User(user.getId(),
                user.getFirstName(),
                user.getLastName());
    }

    // http://localhost:8080/update/1
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update_user(@RequestBody User user,@PathVariable Long id){
        System.out.println(id);
        System.out.println(user.getId());
        return new User(id, user.getFirstName() ,user.getFirstName());
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete_user(@PathVariable Long id){
        return "user %d was deleted".formatted(id);
    }

    // ReponseEntity



}
