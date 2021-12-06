package ru.sfedu.library.api;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.library.beans.*;
import ru.sfedu.library.beans.enums.Outcomes;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.Constants.XML_LIBRARY;
import static ru.sfedu.library.beans.enums.Outcomes.*;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderXML implements IDataProvider{

    private static final Logger log = LogManager.getLogger(DataProviderXML.class);


    @Override
    public Outcomes createUser(User user) {
        List<User> users = extract(XML_USER, User.class);
        if (getUserById(user.getId()).isPresent()) {
            log.error(ERROR_ID_EXIST);
            return EXISTS;
        }
        users.add(user);
        log.debug(users.toString());
        log.info(CREATE_USER);
        return insert(XML_USER, users);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        if (extract(XML_USER, User.class).stream().anyMatch(o -> o.getId().equals(userId))){
            log.info(GET_USER);
            return extract(XML_USER, User.class)
                    .stream().filter(bean -> bean.getId().equals(userId)).findFirst();
        }
        log.error(ERROR_ID_NOT_EXIST);
        return Optional.empty();
    }

    @Override
    public Outcomes updateUser(User user) {
        List<User> users = extract(XML_USER, User.class);
        if (users.stream().noneMatch(bean -> bean.getId().equals(user.getId()))) {
            log.error(ERROR_ID_NOT_EXIST);
            return NOT_EXIST;
        }
        users.removeIf(bean -> bean.getId().equals(user.getId()));
        users.add(user);
        log.debug(users.toString());
        log.info(UPDATE_USER);
        return insert(XML_USER, users);
    }

    @Override
    public Outcomes deleteUserById(Long userId) {
        List<User> users = extract(XML_USER, User.class);
        if (getUserById(userId).isPresent()) {
            users.removeIf(bean -> bean.getId().equals(userId));
            log.info(DELETE_USER);
            return insert(XML_USER, users);
        }
        return NOT_EXIST;
    }

    @Override
    public Outcomes addArtBook(ArtBook artBook) {
        List<ArtBook> books = extract(XML_ARTBOOK, ArtBook.class);
        if (getArtBookById(artBook.getId()).isPresent()) {///getArtBookById(artBook.getId()).stream().anyMatch(o->o.getId().equals(artBook))
            log.error(ERROR_ID_EXIST);
            return EXISTS;
        }
        books.add(artBook);
        log.debug(books.toString());
        log.info(CREATE_ART);
        return insert(XML_ARTBOOK, books);
    }

    @Override
    public Optional<ArtBook> getArtBookById(Long id) {
        if (extract(XML_ARTBOOK, ArtBook.class).stream().anyMatch(o -> o.getId().equals(id))){
            log.info(GET_ART);
            return extract(XML_ARTBOOK, ArtBook.class)
                    .stream().filter(bean -> bean.getId().equals(id)).findFirst();
        }
        log.error(ERROR_ID_NOT_EXIST);
        return Optional.empty();
    }

    @Override
    public List<ArtBook> getAllArtBookByGenre(String genre) {
        List<ArtBook> list = extract(XML_ARTBOOK, ArtBook.class);
        if (list.stream().anyMatch(o -> o.getGenre().equals(genre))){
            log.info(GET_GENRE);
            return extract(XML_ARTBOOK, ArtBook.class)
                    .stream().filter(o -> o.getGenre().equals(genre)).collect(Collectors.toList());
        }   log.error(ERROR_GENRE_NOT_EXIST);
        return List.of();
    }


    @Override
    public List<ArtBook> getAllComics() {
        List<ArtBook> list = extract(XML_ARTBOOK, ArtBook.class);
        if (list.stream().anyMatch(o -> o.getComics().equals(true))){
            log.info(GET_COMICS);
            return extract(XML_ARTBOOK, ArtBook.class)
                    .stream().filter(o -> o.getComics().equals(true)).collect(Collectors.toList());
        }
        log.error(ERROR_COMICS_NOT_EXIST);
        return List.of();
    }


    @Override
    public Outcomes addScientificBook(Scientific scientific) {
        List<Scientific> books = extract(XML_SCIENTIFIC, Scientific.class);
        if (getScientificBookById(scientific.getId()).isPresent()) {
            log.error(ERROR_ID_EXIST);
            return EXISTS;
        }
        books.add(scientific);
        log.debug(books.toString());
        log.info(CREATE_SCIENTIFIC);
        return insert(XML_SCIENTIFIC, books);
    }

    @Override
    public Optional<Scientific> getScientificBookById(Long id) {
        if (extract(XML_SCIENTIFIC, Scientific.class).stream().anyMatch(o -> o.getId().equals(id))){
            log.info(GET_SCIENTIFIC);
            return extract(XML_SCIENTIFIC, Scientific.class)
                    .stream().filter(bean -> bean.getId().equals(id)).findFirst();
        }
        log.error(ERROR_ID_NOT_EXIST);
        return Optional.empty();
    }

    @Override
    public List<Scientific> getScientificBookByDirection(String direction) {
        List<Scientific> list = extract(XML_SCIENTIFIC, Scientific.class);
        if (list.stream().anyMatch(o -> o.getDirection().equals(direction))){
            log.info(GET_DIRECTION);
            return extract(XML_SCIENTIFIC, Scientific.class)
                    .stream().filter(o -> o.getDirection().equals(direction)).collect(Collectors.toList());
        }
        log.error(ERROR_DIRECTION_NOT_EXIST);
        return List.of();
    }

    @Override
    public Outcomes addChildren(Children children) {
        List<Children> books = extract(XML_CHILDREN, Children.class);
        if (getChildrenBookById(children.getId()).isPresent()) {
            log.error(ERROR_ID_EXIST);
            return EXISTS;
        }
        books.add(children);
        log.debug(books.toString());
        log.info(CREATE_CHILDREN);
        return insert(XML_CHILDREN, books);
    }

    @Override
    public Optional<Children> getChildrenBookById(Long id) {
        if (extract(XML_CHILDREN, Children.class).stream().anyMatch(o -> o.getId().equals(id))){
            log.info(GET_CHILDREN);
            return extract(XML_CHILDREN, Children.class)
                    .stream().filter(bean -> bean.getId().equals(id)).findFirst();
        }
        log.error(ERROR_ID_NOT_EXIST);
        return Optional.empty();
    }

    @Override
    public List<Children> getAllChildrenBookIsEducational() {
        List<Children> list = extract(XML_CHILDREN, Children.class);
        if (list.stream().anyMatch(o -> o.getEducational().equals(true))){
            log.info(GET_EDUCATIONAL);
            return extract(XML_CHILDREN, Children.class)
                    .stream().filter(o -> o.getEducational().equals(true)).collect(Collectors.toList());
        }
        log.error(ERROR_EDUCATIONAL_NOT_EXIST);
        return List.of();
    }


    @Override
    public Outcomes delBookByTypeAndId(TypeOfBook typeOfBook, Long id) {
        insert(XML_LIBRARY, extract(XML_LIBRARY, Library.class)
                .stream().filter(o -> !(o.getBook().getTypeOfBook().equals(typeOfBook) && o.getBook().getId().equals(id))).collect(Collectors.toList()));
        switch (typeOfBook) {
            case ART -> {
                List<ArtBook> artBookList = extract(XML_ARTBOOK, ArtBook.class);
                if (getArtBookById(id).isPresent()) {
                    artBookList.removeIf(bean -> bean.getId().equals(id));
                    log.info(DELETE_ART);
                    return insert(XML_ARTBOOK, artBookList);
                }
                return NOT_EXIST;
            }
            case SCIENTIFIC -> {
                List<Scientific> scientificList = extract(XML_SCIENTIFIC, Scientific.class);
                if (getScientificBookById(id).isPresent()) {
                    scientificList.removeIf(bean -> bean.getId().equals(id));
                    log.info(DELETE_SCIENTIFIC);
                    return insert(XML_SCIENTIFIC, scientificList);
                }
                return NOT_EXIST;
            }
            case CHILDREN -> {
                List<Children> childrenList = extract(XML_CHILDREN, Children.class);
                if (getChildrenBookById(id).isPresent()) {
                    childrenList.removeIf(bean -> bean.getId().equals(id));
                    log.info(DELETE_CHILDREN);
                    return insert(XML_CHILDREN, childrenList);
                }
                return NOT_EXIST;
            }
            default -> throw new IllegalStateException("Unexpected value: " + typeOfBook);
        }
    }
    @Override
    public Outcomes addBook(TypeOfBook typeOfBook, ArtBook artBook, Scientific scientific, Children children) {
        try{
            switch (typeOfBook){
                case ART:
                    if (getScientificBookById(scientific.getId()).isEmpty()){
                        return addArtBook(artBook);
                    }
                    break;
                case SCIENTIFIC:
                    if (getScientificBookById(scientific.getId()).isEmpty()){
                        return addScientificBook(scientific);
                    }
                    break;
                case CHILDREN:
                    if (getChildrenBookById(children.getId()).isEmpty()){
                        return addChildren(children);
                    }
                    break;
            }}
        catch (Exception e) {
            log.error(e);
            log.error(ERROR_COMMAND);
            return ERROR;
        }log.error(ERROR_ID_EXIST);
        return EXISTS;
    }

    @Override
    public Outcomes informationReceipt(String method, Long userId) {
        try{
            switch (method.trim().toUpperCase()){
                case ALL_USER_REVIEWS:
                case ALL_USER_RATINGS:
                    if(extract(XML_LIBRARY, Library.class).stream().anyMatch(o -> o.getUser().getId().equals(userId))){
                        return OK;
                    }
                    break;
            }
        }catch (Exception e) {
            log.error(e);
            log.error(ERROR_COMMAND);
            return ERROR;
        }
        log.error(ERROR_COMMAND);
        return ERROR;
    }


    @Override
    public List<String> allUserReviews(Long userId) {
        try {
            if(extract(XML_LIBRARY, Library.class).stream().anyMatch(o -> o.getUser().getId().equals(userId))) {
                log.info(GET_USER_REVIEW);
                return extract(XML_LIBRARY, Library.class)
                        .stream().filter(o -> o.getUser().getId().equals(userId)).map(Library::getReview).collect(Collectors.toList());
            }
        } catch (Exception e) {
            log.error(e);
        }
        log.error(ERROR_ID_NOT_EXIST);
        return List.of();
    }

    @Override
    public Outcomes changeRating(Library library) {
        List<Library> libraryList = extract(XML_LIBRARY, Library.class);
        if (libraryList.stream().noneMatch(bean -> bean.getBook().getId().equals(library.getId()))) {
            log.error(ERROR_ID_NOT_EXIST);
            return NOT_EXIST;
        }
        libraryList.removeIf(bean ->bean.getBook().getId().equals(library.getId()));
        libraryList.add(library);
        log.debug(libraryList.toString());
        log.info(CHANGE_RATING);
        return insert(XML_LIBRARY, libraryList);
    }

    @Override
    public List<Short> allUserRatings(Long userId) {
        try {
            if(extract(XML_LIBRARY, Library.class).stream().anyMatch(o -> o.getUser().getId().equals(userId))) {
                log.info(GET_USER_RATING);
                return extract(XML_LIBRARY, Library.class)
                        .stream().filter(o -> o.getUser().getId().equals(userId)).map(Library::getRating).collect(Collectors.toList());
            }
        } catch (Exception e) {
            log.error(e);
        }
        log.error(ERROR_ID_NOT_EXIST);
        return List.of();
    }


    @Override
    public Outcomes addBookToLibrary(Library library) {
        List<Library> list = extract(XML_LIBRARY, Library.class);
        if (list.stream().anyMatch(o -> o.getId().equals(library.getId()))) {
            log.error(ERROR_ID_EXIST);
            return EXISTS;
        }
        list.add(checkAge(library));//list.add(library);
        log.debug(list.toString());
        log.info(ADD_BOOK_TO_LIBRARY);
        return insert(XML_LIBRARY, list);
    }


    @Override
    public Library checkAge(Library userAge) {
        if( userAge.getUser().getAge()>userAge.getBook().getAgeRestriction()){
            log.info("ok");
            return userAge;
        }
        log.error("error");
        userAge.setReview("You age not exist");
        return userAge;
    }

    @Override
    public List<? extends Book> getBooksByUserId(Long userId) {
        try{
            if(extract(XML_LIBRARY, Library.class).stream().anyMatch(o -> o.getUser().getId().equals(userId))){
                log.info(GET_BOOK_USER);
                return extract(XML_LIBRARY, Library.class)
                        .stream().filter(o -> o.getUser().getId().equals(userId)).map(Library::getBook).collect(Collectors.toList());
            }
        }catch (Exception e) {
            log.error(e);
        }
        log.error(ERROR_ID_NOT_EXIST);
        return List.of();
    }

    @Override
    public Optional<Short> getRatingByBookId(Long bookId) {
        try {
            if(extract(XML_LIBRARY, Library.class).stream().anyMatch(o -> o.getBook().getId().equals(bookId))){
                log.info(GET_BOOK_RATING);
                return extract(XML_LIBRARY, Library.class)
                        .stream().filter(o -> o.getBook().getId().equals(bookId)).map(Library::getRating).findFirst();
            }
        } catch (Exception e) {
            log.error(e);
        }
        log.error(ERROR_ID_NOT_EXIST);
        return Optional.empty();
    }


    @Override
    public Optional<String> getReviewByBookId(Long bookId) {
        try {
            if(extract(XML_LIBRARY, Library.class).stream().anyMatch(o -> o.getBook().getId().equals(bookId))) {
                log.info(GET_BOOK_REVIEW);
                return extract(XML_LIBRARY, Library.class)
                        .stream().filter(o -> o.getBook().getId().equals(bookId)).map(Library::getReview).findFirst();
            }
        } catch (Exception e) {
            log.error(e);
        }
        log.info(ERROR_ID_NOT_EXIST);
        return Optional.empty();
    }

    @Override
    public Outcomes delBookInLibrary(Book book) {
        return insert(XML_LIBRARY, extract(XML_LIBRARY, Library.class).stream().filter(o -> !(o.getBook().getId().equals(book.getId()) && o.getBook().getTypeOfBook().equals(book.getTypeOfBook()))).collect(Collectors.toList()));
    }


    public  <T> Outcomes insert(String key, List<T> list) {
        try {
            FileWriter writer = new FileWriter(getConfigurationEntry(key));
            Serializer serializer = new Persister();
            serializer.write(new Wrapper<T>(list), writer);
            return OK;
        } catch (Exception exception) {
            log.error(exception);
            return ERROR;
        }
    }

    public  <T> List<T> extract(String key, Class<T> c) {
        try {
            FileReader reader = new FileReader(getConfigurationEntry(key));
            Serializer serializer = new Persister();
            Wrapper<T> container = serializer.read(Wrapper.class, reader);
            reader.close();
            if (container.getList() == null) {
                return new ArrayList<>();
            } else {
                return container.getList();
            }
        } catch (Exception exception) {
            log.error(exception);
            return new ArrayList<>();
        }
    }
}
