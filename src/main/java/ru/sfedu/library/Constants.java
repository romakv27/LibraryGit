package ru.sfedu.library;

public class Constants {

    public static final int CONST=2*2;
    public static final String SOUR="ASDC";

    public static final String CSV_USER = "csvUser";

    public static final String XML_USER = "xmlUser";
    public static final String XML_ARTBOOK = "xmlArtBook";
    public static final String XML_SCIENTIFIC = "xmlScientific";
    public static final String XML_CHILDREN = "xmlChildren";
    public static final String XML_LIBRARY = "xmlLibrary";

    public static final String DB_DRIVER = "dbDriver";
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PASSWORD = "dbPassword";

    public static final String MONGO_URL = "mongoUrl";
    public static final String MONGO_DB = "mongoDB";
    public static final String MONGO_COLLECTION = "mongoCollection";
    public static final String INFO_MONGO = "conect to db";



    public static final String ERROR_ID_EXIST = "ERROR-This id exist";
    public static final String ERROR_ID_NOT_EXIST = "ERROR-This id not exist";
    public static final String ERROR_GENRE_NOT_EXIST = "ERROR-This genre not exist";
    public static final String ERROR_COMICS_NOT_EXIST = "ERROR-Comics not exist";
    public static final String ERROR_DIRECTION_NOT_EXIST = "ERROR-This direction not exist";
    public static final String ERROR_EDUCATIONAL_NOT_EXIST = "ERROR-Educational books not exist";
    public static final String ERROR_COMMAND = "Incorrect entry";

    public static final String CREATE_USER = "User is created";
    public static final String GET_USER = "User is displayed";
    public static final String UPDATE_USER = "User is update";
    public static final String DELETE_USER = "User was deleted";

    public static final String CREATE_ART = "Art book is created";
    public static final String GET_ART = "Art book is displayed";
    public static final String GET_GENRE = "Art book with this genre is displayed";
    public static final String GET_COMICS = "Comics is displayed";
    public static final String DELETE_ART = "Art book was deleted";

    public static final String CREATE_SCIENTIFIC = "Scientific book is created";
    public static final String GET_SCIENTIFIC = "Scientific book is displayed";
    public static final String GET_DIRECTION = "Scientific book with this direction is displayed";
    public static final String DELETE_SCIENTIFIC = "Scientific book was deleted";

    public static final String CREATE_CHILDREN = "Children book is created";
    public static final String GET_CHILDREN = "Children book is displayed";
    public static final String GET_EDUCATIONAL = "Educational books is displayed";
    public static final String DELETE_CHILDREN = "Children book was deleted";

    public static final String ADD_BOOK_TO_LIBRARY = "Book added to Library";
    public static final String GET_BOOK_USER = "User book is displayed";
    public static final String GET_BOOK_RATING = "Book rating is displayed";
    public static final String GET_USER_RATING = "Book ratings by user is displayed";
    public static final String GET_BOOK_REVIEW = "Book review is displayed";
    public static final String GET_USER_REVIEW = "Book review by user is displayed";
    public static final String CHANGE_RATING = "Change book rating";


    public static final String ALL_USER_REVIEWS = "ALL_USER_REVIEWS";
    public static final String ALL_USER_RATINGS= "ALL_USER_RATINGS";

    public static final String DEBUG_UPDATE = "Updating a bean";
    public static final String INFO_UPDATE = "Update a bean";
    public static final String INFO_DELETE = "A bean was deleted";
    public static final String DEBUG_GET = "Finding a bean";
    public static final String INFO_GET = "A bean is displayed";
    public static final String EXIST_GET = "A bean is not exist";
    public static final String NOT_EXIST_GET = "A bean is not exist";
    public static final String ERROR_DATA_INITIALIZING_TEST = "Error data initializing for tests";
    public static final String ERROR_CREATE = "A bean with this id exist";//убрать потом
    public static final String EXIST_CREATE = "A bean with this id exist";
    public static final String INFO_CREATE = "A bean with this id is created";
    public static final String DEBUG_CREATE = "Creating a bean";


    public static final String CLI_USER = "user";

    public static final String IDP_CSV = "csv";
    public static final String IDP_XML = "xml";
    public static final String IDP_JDBC = "jdbc";

    public static final String USER_CREATE = "create";
    public static final String USER_GET = "get";
    public static final String USER_UPD = "upd";
    public static final String USER_DEL = "del";





    public static final String SQL_CREATE_USER = "INSERT INTO USER(id, name, surname, age) VALUES(%d, '%s', '%s', %d);";
    public static final String SQL_GET_USER_BY_ID = "SELECT id, name, surname, age FROM USER WHERE id=%d;";
    public static final String SQL_UPD_USER = "UPDATE USER SET name='%s', surname='%s', age=%d WHERE id=%d;";
    public static final String SQL_DEL_USER = "DELETE FROM USER WHERE id=%d;";


}
