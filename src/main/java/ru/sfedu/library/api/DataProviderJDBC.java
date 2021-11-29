package ru.sfedu.library.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.enums.Outcomes;

import java.io.IOException;
import java.sql.*;
import java.util.Collections;
import java.util.Optional;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.beans.enums.Outcomes.*;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;


public class DataProviderJDBC implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderJDBC.class);


    @Override
    public Outcomes createUser(User user) {
        if (getUserById(user.getId()).isPresent()) {
            log.error(EXIST_CREATE);
            return EXISTS;
        }
        log.info(INFO_CREATE);
        return incert(String.format(SQL_CREATE_USER, user.getId(), user.getName(), user.getSurname(), user.getAge()));
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        ResultSet query = select(String.format(SQL_GET_USER_BY_ID, userId));
        try {
            log.info(DEBUG_GET);
            if (query != null && query.next()) {
                log.info(INFO_GET);
                return Optional.of(new User(query.getLong(1), query.getString(2), query.getString(3), query.getInt(4)));
            }
        } catch (SQLException exception) {
            log.error(NOT_EXIST);
        }
        log.error(EXIST_GET);
        return Optional.empty();

    }

    @Override
    public Outcomes updateUser(User user) {
        if (getUserById(user.getId()).isPresent()) {
            log.info(INFO_UPDATE);
            return incert(String.format(SQL_UPD_USER, user.getName(), user.getSurname(), user.getAge(), user.getId()));
        }
        return NOT_EXIST;
    }


    @Override
    public Outcomes deleteUserById(Long userId) {
        if (getUserById(userId).isPresent()) {
            log.info(INFO_DELETE);
            return incert(String.format(SQL_DEL_USER, userId));
        }
        return NOT_EXIST;
    }


//    protected Connection getConnection() throws IOException, ClassNotFoundException {
//        Class.forName(getConfigurationEntry(DB_DRIVER));
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return connection;
//    }

    protected Connection connection() throws Exception {
        Class.forName(getConfigurationEntry(DB_DRIVER));
        Connection connection = DriverManager.getConnection(
                getConfigurationEntry(DB_URL),
                getConfigurationEntry(DB_USER),
                getConfigurationEntry(DB_PASSWORD)
        );
        connection.setAutoCommit(true);
        return connection;
    }

    protected Outcomes incert(String sql) {
        try {
            PreparedStatement statement = connection().prepareStatement(sql);
            statement.executeUpdate();
            connection().close();
            return OK;
        } catch (Exception exception) {
            log.error(exception);
            return ERROR;
        }
    }

    protected ResultSet select(String sql) {
        try {
            PreparedStatement statement = connection().prepareStatement(sql);
            connection().close();
            return statement.executeQuery();
        } catch (Exception exception) {
            log.error(exception);
            return null;
        }
    }

}
