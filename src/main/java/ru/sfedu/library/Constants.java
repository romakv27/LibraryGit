package ru.sfedu.library;

public class Constants {

    public static final int CONST=2*2;
    public static final String SOUR="ASDC";

    public static final String SYS_ENV_KEY = "env";
    public static final String DEFAULT_CONFIG_PATH = "./src/main/resources/enviroment.properties";

    public static final String CSV_USER = "csvUser";

    public static final String XML_USER = "xmlUser";

    public static final String DB_DRIVER = "dbDriver";
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PASSWORD = "dbPassword";

    public static final String DEBUG_CREATE = "Creating a bean";
    public static final String INFO_CREATE = "A bean with this id is created";
    public static final String ERROR_CREATE = "A bean with this id exist";//убрать потом
    public static final String EXIST_CREATE = "A bean with this id exist";
    public static final String DEBUG_UPDATE = "Updating a bean";
    public static final String INFO_UPDATE = "Update a bean";
    public static final String INFO_DELETE = "A bean was deleted";
    public static final String DEBUG_GET = "Finding a bean";
    public static final String INFO_GET = "A bean is displayed";
    public static final String EXIST_GET = "A bean is not exist";

    public static final String CLI_USER = "user";

    public static final String IDP_CSV = "csv";
    public static final String IDP_XML = "xml";

    public static final String USER_CREATE = "create";
    public static final String USER_GET = "get";
    public static final String USER_UPD = "upd";
    public static final String USER_DEL = "del";


    public static final String SQL_CREATE_USER = "INSERT INTO USER(id, name, surname, age) VALUES(%d, '%s', '%s', %d);";
    public static final String SQL_GET_USER_BY_ID = "SELECT id, name, surname, age FROM USER WHERE id=%d;";
    public static final String SQL_UPD_USER = "UPDATE USER SET name='%s', surname='%s', age=%d WHERE id=%d;";
    public static final String SQL_DEL_USER = "DELETE FROM USER WHERE id=%d;";


}
