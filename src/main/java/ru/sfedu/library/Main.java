package ru.sfedu.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.library.api.DataProviderCSV;
import ru.sfedu.library.api.DataProviderXML;
import ru.sfedu.library.api.IDataProvider;
import ru.sfedu.library.beans.User;

import java.io.IOException;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class);

    public static void main(String []args) throws IOException {
        log.debug("Main[0]: starting application.........");
        log.info("info");
        log.error("error");
        log.debug(Constants.CONST);
        log.debug(getConfigurationEntry(SOUR));

    }

    public void logBasicSystemInfo() {
        log.info("Launching the application...");
        log.info("Operating System: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
    }



}
