package ru.levandr.levandrSpring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.levandr.levandrSpring.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {


}
