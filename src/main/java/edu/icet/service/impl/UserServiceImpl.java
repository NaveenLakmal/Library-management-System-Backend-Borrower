package edu.icet.service.impl;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    final ModelMapper modelMapper;
    final UserRepository repository;

    @Override
    public void addUser(User user) {
        UserEntity entity = modelMapper.map(user, UserEntity.class);

        repository.save(entity);
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();

        Iterable<UserEntity> iterbleList = repository.findAll();
        Iterator<UserEntity> iteratorList = iterbleList.iterator();

        while (iteratorList.hasNext()) {
            UserEntity entity = iteratorList.next();
            User user = modelMapper.map(entity, User.class);
            list.add(user);
        }
        return list;

    }

    @Override
    public boolean deleteBook(Long bid) {
        if (repository.existsById(bid)) {
            repository.deleteById(bid);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserId(Long bid) {
        Optional<UserEntity> bookEntity = repository.findById(bid);

        return modelMapper.map(bookEntity, User.class);

    }

    @Override
    public User findByUsername(String username) {


        return modelMapper.map(repository.findByUsername(username), User.class);
    }

    @Override
    public boolean isExistUser(String username) {
        return repository.existsByUsername(username);
    }
}
