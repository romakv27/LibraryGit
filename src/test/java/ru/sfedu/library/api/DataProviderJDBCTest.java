package ru.sfedu.library.api;

import junit.framework.TestCase;
import org.junit.Test;
import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.enums.Outcomes;

import java.util.Optional;

import static org.junit.Assert.*;
import static ru.sfedu.library.beans.enums.Outcomes.*;

public class DataProviderJDBCTest extends BaseBean {
    final IDataProvider provider = new DataProviderJDBC();
    Outcomes result;

    @Test
    public void testCrudUser(){


//       assertEquals(provider.createUser(new User(1L, "Ivan", "Ivanov", 18)), OK);
//       assertNotEquals(provider.createUser(new User(1L, "Ivan", "Ivanov", 18)), ERROR);
//
//        assertNotEquals(provider.getUserById(2L), ERROR);
//        assertTrue(provider.getUserById(1L).isPresent());
//        assertFalse(provider.getUserById(7L).isPresent());
//
//        assertEquals(provider.updateUser(new User(1L, "Ivan", "Ivanov", 21)), OK);
//        assertNotEquals(provider.updateUser(new User(2L, "Ivan", "Ivanov", 21)), ERROR);
//
//
//        assertEquals(provider.deleteUserById(1L), OK);
//        assertNotEquals(provider.deleteUserById(1L), ERROR);

    }

    @Test
    public void testCrudUserPos(){

        User user;
        User userUpdate;
        Optional<User> optionalUser;

        user = getUser();
        userUpdate = getUserUpdate();

        optionalUser = provider.getUserById(user.getId());

        result = provider.deleteUserById(user.getId());
        System.out.printf("NEGATIVE — Delete User: %s\n", result.name());
        assertNotEquals(result, ERROR);

        result = provider.updateUser(userUpdate);
        System.out.printf("NEGATIVE — Update User: %s\n", result.name());
        assertNotEquals(result, ERROR);
        System.out.printf("NEGATIVE — Get User: %s\n", optionalUser.toString());
        assertFalse(optionalUser.isPresent());
//
        result = provider.createUser(user);
        System.out.printf("POSITIVE — Create User: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.createUser(user);
        System.out.printf("NEGATIVE — Create User: %s\n", result.name());
        assertEquals(result, EXISTS);

        optionalUser = provider.getUserById(user.getId());
        System.out.printf("POSITIVE — Get User: %s\n", optionalUser.toString());
        assertTrue(optionalUser.isPresent());

        result = provider.updateUser(userUpdate);
        System.out.printf("POSITIVE — Update User: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.deleteUserById(user.getId());
        System.out.printf("POSITIVE — Delete User: %s\n", result.name());
        assertEquals(result, OK);


    }

}