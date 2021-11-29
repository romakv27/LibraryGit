package ru.sfedu.library.api;

import junit.framework.TestCase;
import org.junit.Test;
import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.enums.Outcomes;

import static ru.sfedu.library.beans.enums.Outcomes.*;

public class DataProviderXMLTest extends TestCase {
    final IDataProvider provider = new DataProviderXML();
    Outcomes result;

    @Test
    public void testCrudUser(){


//        assertEquals(provider.createUser(new User(12L, "Ivan", "Ivanov", 18)), OK);
//        assertEquals(provider.createUser(new User(1L, "Ivan", "Ivanov", 18)), EXISTS);
//
//        assertTrue(provider.getUserById(1L).isPresent());
//        assertFalse(provider.getUserById(7L).isPresent());
//
//        assertEquals(provider.updateUser(new User(1L, "Ivan", "Ivanov", 21)), OK);
//
//        assertEquals(provider.deleteUserById(12L), OK);

    }

    @Test
    public  void testCrudUserPosNeg(){

//        System.out.printf("Get User[NEGATIVE]: %s\n", provider.getUserById(1L).toString());
//        assertFalse(provider.getUserById(1L).isPresent());
//
//        result = provider.deleteUserById(1L);
//        System.out.printf("Delete User[NEGATIVE]: %s\n", result.name());
//        assertFalse(provider.getUserById(1L).isPresent());
//
//        result = provider.updateUser(new User(1L, "Ivan", "Ivanov", 22));
//        System.out.printf("Update User[NEGATIVE]: %s\n", result.name());
//        assertEquals(result, ERROR);
//
//        result = provider.createUser(new User(1L, "Ivan", "Ivanov", 18));
//        System.out.printf("Create User[POSITIVE]: %s\n", result.name());
//        assertEquals(result, OK);
//
//        System.out.printf("Get User[POSITIVE]: %s\n", provider.getUserById(1L).toString());
//        assertTrue(provider.getUserById(1L).isPresent());
//
//        result = provider.createUser(new User(1L, "Ivan", "Ivanov", 18));
//        System.out.printf("Create User[NEGATIVE]: %s\n", result.name());
//        assertEquals(result, EXISTS);
//
//        result = provider.deleteUserById(1L);
//        System.out.printf("Delete User[POSITIVE]: %s\n", result.name());
//        assertEquals(result, OK);

    }
}