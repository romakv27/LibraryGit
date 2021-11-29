package ru.sfedu.library.api;

import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.enums.Outcomes;

import java.util.Optional;

public interface IDataProvider {

    Outcomes createUser(User user);

    Optional<User> getUserById(Long userId);

    Outcomes updateUser(User user);

    Outcomes deleteUserById(Long userId);

}
