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

    @GetMapping("/find-by-bid/{bid}")
    public User getUserId(@PathVariable Long bid){
        return service.getUserId(bid);
    }

    @GetMapping("/find-by-username/{username}")
    public User getUserName(@PathVariable String username){
        return service.findByUsername(username);
    }

    @GetMapping("/is-exist-user/{username}")
    public boolean isExistUser(@PathVariable String username){

        boolean existUser = service.isExistUser(username);
        System.out.println(existUser);
        return existUser;
    }

}
