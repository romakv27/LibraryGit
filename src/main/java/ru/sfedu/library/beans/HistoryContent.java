package ru.sfedu.library.beans;

import java.util.Date;

public class HistoryContent {

    private final Date timestamp;
    private final String method;
    private final Object object;

    public HistoryContent(Date timestamp, String method, Object object) {
        this.timestamp = timestamp;
        this.method = method;
        this.object = object;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMethod() {
        return method;
    }

    public Object getObject() {
        return object;
    }
}
