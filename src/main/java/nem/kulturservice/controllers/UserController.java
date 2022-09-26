package nem.kulturservice.controllers;

import nem.kulturservice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nem.kulturservice.services.IUserService;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Set<User>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser (@RequestBody User user){
        String message = "";
        if(userService.save(user) != null){
        message = "User " + user.getName();
        } else {
        message = "Error creating " + user.getName();
        }
    return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/findUserByName")
    public ResponseEntity<List<User>> findUserByName(String name){
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.OK);
    }
}
