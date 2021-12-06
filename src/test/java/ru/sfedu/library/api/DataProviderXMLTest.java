package ru.sfedu.library.api;

import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import ru.sfedu.library.beans.*;
import ru.sfedu.library.beans.enums.Outcomes;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static ru.sfedu.library.Constants.XML_USER;
import static ru.sfedu.library.beans.enums.Outcomes.*;

public class DataProviderXMLTest extends BaseBean {
    private final static Logger log = LogManager.getLogger(DataProviderXMLTest.class);
    final IDataProvider provider = new DataProviderXML();
    public DataProviderXML providers = new DataProviderXML();
    Outcomes result;

//    @Before
//    public void InitTestData(){
//        try {
//            List<User> listUser = new ArrayList<>();
//            listUser.add(createUser(10L, "Alex", "Ivanov", 20 ));
//
//
//            providers.insert(XML_USER, listUser);
//        }catch (Exception e){
//            log.error("ERROR_DATA_INITIALIZING_TEST");
//            log.error(e);
//        }
//    }



    @Test
    public void testCrudUser(){
        User user;
        User userUpdate;
        Optional<User> optionalUser;

        user = getUser();
        userUpdate = getUserUpdate();

        optionalUser = provider.getUserById(user.getId());
        System.out.printf("NEGATIVE — Get User: %s\n", optionalUser.toString());
        assertFalse(optionalUser.isPresent());

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

        result = provider.deleteUserById(user.getId());
        System.out.printf("NEGATIVE — Delete User: %s\n", result.name());
        assertNotEquals(result, ERROR);

        result = provider.updateUser(userUpdate);
        System.out.printf("NEGATIVE — Update User: %s\n", result.name());
        assertNotEquals(result, ERROR);
    }


    @Test
    public  void testCrudArtBook(){
        ArtBook artBook;
        artBook = getArtBook();
        Optional<ArtBook> optionalArtBook;
        List<ArtBook> listArtBook;

        ArtBook comics;
        comics=getArtBookComics();

        optionalArtBook = provider.getArtBookById(artBook.getId());
        System.out.printf("NEGATIVE — Get Art book: %s\n", optionalArtBook.toString());
        assertFalse(optionalArtBook.isPresent());

        result = provider.addArtBook(artBook);
        System.out.printf("POSITIVE — Add Art book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.addArtBook(artBook);
        System.out.printf("NEGATIVE — Add Art book: %s\n", result.name());
        assertEquals(result, EXISTS);

        optionalArtBook = provider.getArtBookById(artBook.getId());
        System.out.printf("POSITIVE — Get Art book: %s\n", optionalArtBook.toString());
        assertTrue(optionalArtBook.isPresent());

        listArtBook = provider.getAllArtBookByGenre("H");
        System.out.printf("POSITIVE — Get by genre: %s\n", listArtBook.toString());
        assertFalse(listArtBook.isEmpty());

        listArtBook = provider.getAllArtBookByGenre("S");
        System.out.printf("NEGATIVE — Get by genre: %s\n", listArtBook.toString());
        assertTrue(listArtBook.isEmpty());

        listArtBook = provider.getAllComics();
        System.out.printf("NEGATIVE — Get comics: %s\n", listArtBook.toString());
        assertTrue(listArtBook.isEmpty());

        result = provider.delBookByTypeAndId(artBook.getTypeOfBook(), artBook.getId());
        System.out.printf("POSITIVE — Delete book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.delBookByTypeAndId(artBook.getTypeOfBook(), artBook.getId());
        System.out.printf("NEGATIVE — Delete book: %s\n", result.name());
        assertEquals(result, NOT_EXIST);


        result = provider.addArtBook(comics);
        System.out.printf("POSITIVE — Add comics: %s\n", result.name());
        assertEquals(result, OK);

        listArtBook = provider.getAllComics();
        System.out.printf("POSITIVE — Get comics: %s\n", listArtBook.toString());
        assertFalse(listArtBook.isEmpty());

        result = provider.delBookByTypeAndId(comics.getTypeOfBook(), comics.getId());
        System.out.printf("POSITIVE — Delete comics: %s\n", result.name());
        assertEquals(result, OK);

    }

    @Test
    public void testCrudScientific(){
        Scientific scientific;
        scientific = getScientific();
        Optional<Scientific> optionalScientific;
        List<Scientific> listScientific;

        optionalScientific = provider.getScientificBookById(scientific.getId());
        System.out.printf("NEGATIVE — Get scientific book: %s\n", optionalScientific.toString());
        assertFalse(optionalScientific.isPresent());

        result = provider.addScientificBook(scientific);
        System.out.printf("POSITIVE — Add scientific book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.addScientificBook(scientific);
        System.out.printf("NEGATIVE — Add scientific book: %s\n", result.name());
        assertEquals(result, EXISTS);

        optionalScientific = provider.getScientificBookById(scientific.getId());
        System.out.printf("POSITIVE — Get scientific book: %s\n", optionalScientific.toString());
        assertTrue(optionalScientific.isPresent());

        listScientific = provider.getScientificBookByDirection("java");
        System.out.printf("POSITIVE — Get by direction: %s\n", listScientific.toString());
        assertFalse(listScientific.isEmpty());

        listScientific = provider.getScientificBookByDirection("Not exist direction");
        System.out.printf("NEGATIVE — Get by direction: %s\n", listScientific.toString());
        assertTrue(listScientific.isEmpty());

        result = provider.delBookByTypeAndId(scientific.getTypeOfBook(), scientific.getId());
        System.out.printf("POSITIVE — Delete book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.delBookByTypeAndId(scientific.getTypeOfBook(), scientific.getId());
        System.out.printf("NEGATIVE — Delete book: %s\n", result.name());
        assertEquals(result, NOT_EXIST);

    }

    @Test
    public void testCrudChildren(){
        Children children;
        children = getChildren();
        Optional<Children> optionalChildren;
        List<Children> listChildren;

        Children educational;
        educational = getChildrenEduc();

        optionalChildren = provider.getChildrenBookById(children.getId());
        System.out.printf("NEGATIVE — Get children book: %s\n", optionalChildren.toString());
        assertFalse(optionalChildren.isPresent());

        result = provider.addChildren(children);
        System.out.printf("POSITIVE — Add children book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.addChildren(children);
        System.out.printf("NEGATIVE — Add children book: %s\n", result.name());
        assertEquals(result, EXISTS);

        optionalChildren = provider.getChildrenBookById(children.getId());
        System.out.printf("POSITIVE — Get children book: %s\n", optionalChildren.toString());
        assertTrue(optionalChildren.isPresent());

        listChildren = provider.getAllChildrenBookIsEducational();
        System.out.printf("NEGATIVE — Get educational books: %s\n", listChildren.toString());
        assertTrue(listChildren.isEmpty());

        result = provider.delBookByTypeAndId(children.getTypeOfBook(), children.getId());
        System.out.printf("POSITIVE — Delete book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.delBookByTypeAndId(children.getTypeOfBook(), children.getId());
        System.out.printf("NEGATIVE — Delete book: %s\n", result.name());
        assertEquals(result, NOT_EXIST);


        result = provider.addChildren(educational);
        System.out.printf("POSITIVE — Add educational children book: %s\n", result.name());
        assertEquals(result, OK);

        listChildren = provider.getAllChildrenBookIsEducational();
        System.out.printf("POSITIVE — Get educational books: %s\n", listChildren.toString());
        assertFalse(listChildren.isEmpty());

        result = provider.delBookByTypeAndId(educational.getTypeOfBook(), educational.getId());
        System.out.printf("POSITIVE — Delete book: %s\n", result.name());
        assertEquals(result, OK);
    }

    @Test
    public  void testCrudLibrary(){
        ArtBook artBook;
        artBook = getArtBook();
        User user;
        user = getUser();
        Library library;
        Library libraryChangeRat;
        library = getLibrary();
        libraryChangeRat = getChangeRating();

        List<? extends Book> listUserBook;
        Optional<Short> optionalRating;
        Optional<String> optionalReview;
        List<Short> listRating;
        List<String> optionalRevUser;

        assertEquals(provider.addArtBook(getArtBook()), OK);
        Optional<? extends Book> optionalBook = provider.getArtBookById(artBook.getId());


        listUserBook = provider.getBooksByUserId(user.getId());
        System.out.printf("NEGATIVE — Get User books: %s\n", listUserBook.toString());
        assertTrue(listUserBook.isEmpty());

        optionalRating = provider.getRatingByBookId(artBook.getId());
        System.out.printf("NEGATIVE — Book rating: %s\n", optionalRating.toString());
        assertTrue(optionalRating.isEmpty());

        listRating = provider.allUserRatings(user.getId());
        System.out.printf("NEGATIVE — Get rating by user: %s\n", listRating.toString());
        assertTrue(listRating.isEmpty());

        optionalReview = provider.getReviewByBookId(artBook.getId());
        System.out.printf("NEGATIVE — Book review: %s\n", optionalReview.toString());
        assertTrue(optionalReview.isEmpty());

        optionalRevUser = provider.allUserReviews(user.getId());
        System.out.printf("NEGATIVE — Get reviews by user: %s\n", optionalRevUser.toString());
        assertTrue(optionalRevUser.isEmpty());

        result = provider.addBookToLibrary(library);
        System.out.printf("POSITIVE — Add book to Library: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.addBookToLibrary(library);
        System.out.printf("NEGATIVE — Add book to Library: %s\n", result.name());
        assertEquals(result, EXISTS);

        listUserBook = provider.getBooksByUserId(user.getId());
        System.out.printf("POSITIVE — Get User books: %s\n", listUserBook.toString());
        assertFalse(listUserBook.isEmpty());

        optionalRating = provider.getRatingByBookId(artBook.getId());
        System.out.printf("POSITIVE — Book rating: %s\n", optionalRating.toString());
        assertFalse(optionalRating.isEmpty());

        result = provider.changeRating(libraryChangeRat);
        System.out.printf("POSITIVE — Change rating: %s\n", result.name());
        assertEquals(result, OK);

        listRating = provider.allUserRatings(user.getId());
        System.out.printf("POSITIVE — Get rating by user: %s\n", listRating.toString());
        assertFalse(listRating.isEmpty());

        optionalReview = provider.getReviewByBookId(artBook.getId());
        System.out.printf("POSITIVE — Book review: %s\n", optionalReview.toString());
        assertFalse(optionalReview.isEmpty());

        optionalRevUser = provider.allUserReviews(user.getId());
        System.out.printf("POSITIVE — Get reviews by user: %s\n", optionalRevUser.toString());
        assertFalse(optionalRevUser.isEmpty());

        result = provider.delBookInLibrary(optionalBook.get());
        System.out.printf("POSITIVE — Delete Book in Library: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.delBookInLibrary(optionalBook.get());
        System.out.printf("NEGATIVE — Delete Book in Library: %s\n", result.name());
        assertNotEquals(result, NOT_EXIST);

        result = provider.changeRating(libraryChangeRat);
        System.out.printf("NEGATIVE — Change rating: %s\n", result.name());
        assertEquals(result, NOT_EXIST);

        assertEquals(provider.delBookByTypeAndId(artBook.getTypeOfBook(), artBook.getId()), OK);

    }

    @Test
    public void testBaseMeth(){

        ArtBook artBook;
        artBook = getArtBook();
        Scientific scientific;
        scientific = getScientific();
        Children children;
        children = getChildren();

        Library library;
        library = getLibrary();

        result = provider.addBook(artBook.getTypeOfBook(),artBook,scientific,children);
        System.out.printf("POSITIVE — add book: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.addBook(artBook.getTypeOfBook(),artBook,scientific,children);
        System.out.printf("NEGATIVE — add book: %s\n", result.name());
        assertEquals(result, EXISTS);

        Optional<? extends Book> optionalBook = provider.getArtBookById(artBook.getId());

        result = provider.addBookToLibrary(library);
        System.out.printf("POSITIVE — Add book to Library: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.informationReceipt("all_user_reviews", 1L);
        System.out.printf("POSITIVE — all_user_reviews: %s\n", result.name());
        assertEquals(result, OK);
        result = provider.informationReceipt("all_user_ratings", 1L);
        System.out.printf("POSITIVE — all_user_ratings: %s\n", result.name());
        assertEquals(result, OK);

        result = provider.informationReceipt("all_usser_reviews", 1L);
        System.out.printf("NEGATIVE — all_user_reviews: %s\n", result.name());
        assertEquals(result, ERROR);
        result = provider.informationReceipt("all_user_wratings", 11L);
        System.out.printf("NEGATIVE — all_user_ratings: %s\n", result.name());
        assertEquals(result, ERROR);


        result = provider.delBookInLibrary(optionalBook.get());
        System.out.printf("POSITIVE — Delete Book in Library: %s\n", result.name());
        assertEquals(result, OK);

        assertEquals(provider.delBookByTypeAndId(artBook.getTypeOfBook(), artBook.getId()), OK);

    }
}