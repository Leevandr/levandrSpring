package ru.levandr.levandrSpring.service;


import ru.levandr.levandrSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levandr.levandrSpring.entity.UserEntity;
import ru.levandr.levandrSpring.exception.UserAlreadyExistException;
import ru.levandr.levandrSpring.exception.UserNotFoundException;
import ru.levandr.levandrSpring.repository.UserRepo;

@Service

public class UserService {

    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("This username already exist");
        }
        return userRepo.save(user);

    }

    public User getOne (Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("This username not found");
        }
        return User.toModel(user);
    }

    public Long delete (Long id) {
         userRepo.deleteById(id);
         return id;
    }



}
