package com.kushmiruk.chapter04.propertyeditor;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {
    private static final Logger LOGGER = Logger.getLogger(PropertyEditorBean.class);
    private byte[] bytes;
    private Class aClass;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float aFloat;
    private File file;
    private InputStream inputStream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;

    public void setBytes(byte[] bytes) {
        LOGGER.info("Setting bytes: " + bytes);
        this.bytes = bytes;
    }

    public void setaClass(Class aClass) {
        LOGGER.info("Setting class: " + aClass.getName());
        this.aClass = aClass;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        LOGGER.info("Setting boolean: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        LOGGER.info("Setting stringList with size: " + stringList.size());
        this.stringList = stringList;

        for (String string : stringList) {
            LOGGER.info("String member: " + string);
        }
    }

    public void setaFloat(Float aFloat) {
        LOGGER.info("Setting float: " + aFloat);
        this.aFloat = aFloat;
    }

    public void setFile(File file) {
        LOGGER.info("Setting file: " + file.getName());
        this.file = file;
    }

    public void setInputStream(InputStream inputStream) {
        LOGGER.info("Setting stream: " + inputStream);
        this.inputStream = inputStream;
    }

    public void setLocale(Locale locale) {
        LOGGER.info("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        LOGGER.info("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        LOGGER.info("Setting properties: " + properties);
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        LOGGER.info("Setting trim string: " + trimString);
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        LOGGER.info("Setting url: " + url);
        this.url = url;
    }

    public void setDate(Date date) {
        LOGGER.info("Setting date: " + date);
        this.date = date;
    }
}
