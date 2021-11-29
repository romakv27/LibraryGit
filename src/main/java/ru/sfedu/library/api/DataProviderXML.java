package ru.sfedu.library.api;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.Wrapper;
import ru.sfedu.library.beans.enums.Outcomes;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.beans.enums.Outcomes.*;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderXML implements IDataProvider{

    private static final Logger log = LogManager.getLogger(DataProviderXML.class);


    @Override
    public Outcomes createUser(User user) {
        log.debug(DEBUG_CREATE);
        List<User> users = extract(XML_USER, User.class);
        if (getUserById(user.getId()).isPresent()) {
            log.error(ERROR_CREATE);
            return EXISTS;
        }
        users.add(user);
        log.info(INFO_CREATE);
        return insert(XML_USER, users);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        log.info(INFO_GET);
        return extract(XML_USER, User.class)
                .stream().filter(bean -> bean.getId().equals(userId)).findFirst();
    }

    @Override
    public Outcomes updateUser(User user) {
        log.debug(DEBUG_UPDATE);
        List<User> users = extract(XML_USER, User.class);
        if (users.stream().noneMatch(bean -> bean.getId().equals(user.getId()))) {
            return ERROR;
        }
        users.removeIf(bean -> bean.getId().equals(user.getId()));
        users.add(user);
        log.info(INFO_UPDATE);
        return insert(XML_USER, users);
    }

    @Override
    public Outcomes deleteUserById(Long userId) {
        List<User> users = extract(XML_USER, User.class);
        users.removeIf(bean -> bean.getId().equals(userId));
        log.info(INFO_DELETE);
        return insert(XML_USER, users);
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
