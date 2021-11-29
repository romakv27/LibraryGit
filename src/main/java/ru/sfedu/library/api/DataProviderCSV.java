package ru.sfedu.library.api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.library.beans.User;
import ru.sfedu.library.beans.enums.Outcomes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.beans.enums.Outcomes.*;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderCSV implements IDataProvider{

    private static final Logger log = LogManager.getLogger(DataProviderCSV.class);


    @Override
    public Outcomes createUser(User user) {
        log.debug(DEBUG_CREATE);
        if (getUserById(user.getId()).isPresent()) {
            log.error(ERROR_CREATE);
            return EXISTS;
        }
        log.info(INFO_CREATE);
        return insert(CSV_USER, Collections.singletonList(user), true);
    }


    @Override
    public Optional<User> getUserById(Long userId) {
        log.info(INFO_GET);
        return extract(CSV_USER, User.class).stream().filter(user -> user.getId().equals(userId)).findFirst();
    }


    @Override
    public Outcomes updateUser(User user) {
        log.debug(DEBUG_UPDATE);
        if (getUserById(user.getId()).isPresent()) {
            deleteUserById(user.getId());
        }
        log.info(INFO_UPDATE);
        return createUser(user);
    }


    @Override
    public Outcomes deleteUserById(Long userId) {
        List<User> user = extract(CSV_USER, User.class);
        user.removeIf(bean -> bean.getId().equals(userId));
        log.info(INFO_DELETE);
        return insert(CSV_USER, user, false);
    }


    public <T> Outcomes insert(String key, List<T> list, boolean append){
        try {
            FileWriter writer = new FileWriter(getConfigurationEntry(key), append);
            CSVWriter csvWriter = new CSVWriter(writer);
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(csvWriter).withApplyQuotesToAll(false).build();
            beanToCsv.write(list);
            csvWriter.close();
            return OK;
        } catch (Exception exception) {
            log.error(exception);
            return ERROR;
        }
    }

    public <T> List <T> extract(String key, Class<T> c){
        List <T> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(getConfigurationEntry(key));
            CSVReader csvReader = new CSVReader(reader);
            list = new CsvToBeanBuilder<T>(csvReader).withType(c).build().parse();
            csvReader.close();
        } catch (Exception exception) {
            log.error(exception);
        }
        return list;
    }

}
