package ru.levandr.levandrSpring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levandr.levandrSpring.entity.TodoEntity;
import ru.levandr.levandrSpring.entity.UserEntity;
import ru.levandr.levandrSpring.model.Todo;
import ru.levandr.levandrSpring.repository.TodoRepo;
import ru.levandr.levandrSpring.repository.UserRepo;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }
    public Todo completeTodo(Long id) {
        TodoEntity todo  = todoRepo.findById(id).get();
        todo.setComplete(!todo.getComplete());
        return Todo.toModel(todoRepo.save(todo));

    }
}
