package ru.sfedu.library.api;

import ru.sfedu.library.beans.User;

public class BaseBean {

    public User getUser(){
        return new User(1L, "Ivan", "Ivanov", 16);
    }
    public User getUserUpdate(){
        return new User(1L, "Ivan", "Ivanov", 18);
    }

}
