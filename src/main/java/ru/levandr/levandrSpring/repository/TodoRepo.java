package ru.levandr.levandrSpring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.levandr.levandrSpring.entity.TodoEntity;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
