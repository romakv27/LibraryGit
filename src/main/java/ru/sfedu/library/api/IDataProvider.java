package ru.sfedu.library.api;

import ru.sfedu.library.beans.*;
import ru.sfedu.library.beans.enums.Outcomes;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.util.List;
import java.util.Optional;

public interface IDataProvider {

    Outcomes createUser(User user);
    Optional<User> getUserById(Long userId);
    Outcomes updateUser(User user);
    Outcomes deleteUserById(Long userId);

    Outcomes addArtBook(ArtBook artBook);
    Optional<ArtBook> getArtBookById(Long id);
    List<ArtBook> getAllArtBookByGenre(String genre);
    List<ArtBook> getAllComics();

    Outcomes addScientificBook(Scientific scientific);
    Optional<Scientific> getScientificBookById(Long id);
    List<Scientific> getScientificBookByDirection(String direction);

    Outcomes addChildren(Children children);
    Optional<Children> getChildrenBookById(Long id);
    List<Children> getAllChildrenBookIsEducational();

    Outcomes addBook(TypeOfBook typeOfBook, ArtBook artBook, Scientific scientific, Children children);


    Outcomes delBookByTypeAndId(TypeOfBook typeOfBook, Long id);

    Outcomes informationReceipt(String method, Long userId);

    Outcomes changeRating(Library library);

    Outcomes addBookToLibrary(Library library);
    Library checkAge(Library userAge);///включающий, тест
    List<? extends Book> getBooksByUserId(Long userId);
    Optional<Short> getRatingByBookId(Long bookId);
    Optional<String> getReviewByBookId(Long bookId);
    List<Short> allUserRatings(Long userId);
    List<String> allUserReviews(Long userId);
    Outcomes delBookInLibrary(Book book);

}
