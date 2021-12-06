package ru.sfedu.library.api;

import ru.sfedu.library.beans.*;
import ru.sfedu.library.beans.enums.Outcomes;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.util.List;
import java.util.Optional;

public abstract class IDataProvider {

    abstract Outcomes createUser(User user);
    abstract Optional<User> getUserById(Long userId);
    abstract Outcomes updateUser(User user);
    abstract Outcomes deleteUserById(Long userId);

    abstract Outcomes addArtBook(ArtBook artBook);
    abstract Optional<ArtBook> getArtBookById(Long id);
    abstract List<ArtBook> getAllArtBookByGenre(String genre);
    abstract List<ArtBook> getAllComics();

    abstract Outcomes addScientificBook(Scientific scientific);
    abstract Optional<Scientific> getScientificBookById(Long id);
    abstract List<Scientific> getScientificBookByDirection(String direction);

    abstract Outcomes addChildren(Children children);
    abstract Optional<Children> getChildrenBookById(Long id);
    abstract List<Children> getAllChildrenBookIsEducational();

    abstract Outcomes addBook(TypeOfBook typeOfBook, ArtBook artBook, Scientific scientific, Children children);


    abstract Outcomes delBookByTypeAndId(TypeOfBook typeOfBook, Long id);

    abstract Outcomes informationReceipt(String method, Long userId);

    abstract Outcomes changeRating(Library library);

    abstract Outcomes addBookToLibrary(Library library);
    abstract Library checkAge(Library userAge);///включающий, тест
    abstract List<? extends Book> getBooksByUserId(Long userId);
    abstract Optional<Short> getRatingByBookId(Long bookId);
    abstract Optional<String> getReviewByBookId(Long bookId);
    abstract List<Short> allUserRatings(Long userId);
    abstract List<String> allUserReviews(Long userId);
    abstract Outcomes delBookInLibrary(Book book);

}
