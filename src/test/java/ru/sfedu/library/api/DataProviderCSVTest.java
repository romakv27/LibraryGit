package ru.sfedu.library.api;

import junit.framework.TestCase;
import org.junit.Test;
import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.enums.Outcomes;


import static ru.sfedu.library.beans.enums.Outcomes.EXISTS;
import static ru.sfedu.library.beans.enums.Outcomes.OK;

public class DataProviderCSVTest extends TestCase {
    final IDataProvider provider = new DataProviderCSV();
    Outcomes result;

    @Test
    public void testCrudUser(){

//
//     assertEquals(provider.createUser(new User(1L, "Ivan", "Ivanov", 18)), OK);
//        assertEquals(provider.createUser(new User(1L, "Ivan", "Ivanov", 18)), EXISTS);
//
//        assertTrue(provider.getUserById(1L).isPresent());
//        assertFalse(provider.getUserById(7L).isPresent());
//
//        assertEquals(provider.updateUser(new User(1L, "Ivan", "Ivanov", 21)), OK);

//        assertEquals(provider.deleteUserById(1L), OK);

    }



    @Test
    public  void testCrudUserPosNeg(){
//        result = provider.createUser(new User(2L, "Ivan", "Ivanov", 18));
//        System.out.printf("Create User[POSITIVE]: %s\n", result.name());
//        assertEquals(result, OK);
//
//        result = provider.createUser(new User(2L, "Ivan", "Ivanov", 18));
//        System.out.printf("Create User[NEGATIVE]: %s\n", result.name());
//        assertEquals(result, EXISTS);

    }


}