package edu.icet.controller;

import edu.icet.dto.User;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class BorrowerController {

    final UserService service;

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @GetMapping("/get")
    public List<User>getAllUser(){
        return service.getAllUser();
    }

    @DeleteMapping("/{bid}")
    public void deleteUser(@PathVariable Long bid){
        service.deleteBook(bid);
    }

}
