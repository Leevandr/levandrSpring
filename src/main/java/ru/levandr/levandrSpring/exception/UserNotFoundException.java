package ru.levandr.levandrSpring.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }

    public void userTest(){

        Exception e = new Exception();
        e.printStackTrace();

    }
}
