package com.kushmiruk.videocourse.core.app;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private static final Logger LOGGER = Logger.getLogger(FileEventLogger.class);
    private String fileName;
    private File file;

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
            LOGGER.info(FileUtils.readFileToString(file));
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        this.file = new File(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
