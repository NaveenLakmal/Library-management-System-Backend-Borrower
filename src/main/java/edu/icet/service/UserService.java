package edu.icet.service;

import edu.icet.dto.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User>getAllUser();

    boolean deleteBook(Long bid);
}
