package ru.sfedu.library.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import ru.sfedu.library.beans.*;
import ru.sfedu.library.beans.enums.Outcomes;


import ru.sfedu.library.beans.enums.TypeOfBook;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.Constants.INFO_MONGO;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public abstract class IDataProvider {
    private static final Logger log = LogManager.getLogger(IDataProvider.class);


    abstract Outcomes createUser(User user);
    abstract Optional<User> getUserById(Long userId);
//    abstract Outcomes updateUser(User user);
//    abstract Outcomes deleteUserById(Long userId);
//
//    abstract Outcomes addArtBook(ArtBook artBook);
//    abstract Optional<ArtBook> getArtBookById(Long id);
//    abstract List<ArtBook> getAllArtBookByGenre(String genre);
//    abstract List<ArtBook> getAllComics();
//
//    abstract Outcomes addScientificBook(Scientific scientific);
//    abstract Optional<Scientific> getScientificBookById(Long id);
//    abstract List<Scientific> getScientificBookByDirection(String direction);
//
//    abstract Outcomes addChildren(Children children);
//    abstract Optional<Children> getChildrenBookById(Long id);
//    abstract List<Children> getAllChildrenBookIsEducational();
//
//    abstract Outcomes addBook(TypeOfBook typeOfBook, ArtBook artBook, Scientific scientific, Children children);
//
//
//    abstract Outcomes delBookByTypeAndId(TypeOfBook typeOfBook, Long id);
//
//    abstract Outcomes informationReceipt(String method, Long userId);
//
//    abstract Outcomes changeRating(Library library);
//
//    abstract Outcomes addBookToLibrary(Library library);
//    abstract Library checkAge(Library userAge);///включающий, тест
//    abstract List<? extends Book> getBooksByUserId(Long userId);
//    abstract Optional<Short> getRatingByBookId(Long bookId);
//    abstract Optional<String> getReviewByBookId(Long bookId);
//    abstract List<Short> allUserRatings(Long userId);
//    abstract List<String> allUserReviews(Long userId);
//    abstract Outcomes delBookInLibrary(Book book);


    public void saveToLog(HistoryContent object) throws IOException {
        MongoClient client = MongoClients.create(getConfigurationEntry(MONGO_URL));
        MongoDatabase database = client.getDatabase(getConfigurationEntry(MONGO_DB));
        MongoCollection<Document> collection = database.getCollection(getConfigurationEntry(MONGO_COLLECTION));

        log.info(INFO_MONGO);

        Document document = Document.parse(objectToJSON(object));
        collection.insertOne(document);
    }

    private String objectToJSON(HistoryContent object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

}
