package com.kushmiruk.videocourse.core.app;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private static final Logger LOGGER = Logger.getLogger(CacheFileEventLogger.class);
    private int cacheSize;
    private List<Event> cache;
    private File file;

    public CacheFileEventLogger(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cacheSize == cache.size()) {
            try {
                writeCacheIntoFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            cache.clear();
        }
    }

    public void destroy() {
        LOGGER.info("Destroy method:");
        if (!cache.isEmpty()) {
            try {
                writeCacheIntoFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void writeCacheIntoFile() throws IOException {
        file = File.createTempFile("test", "txt");
        FileUtils.writeLines(file, cache);
        LOGGER.info(FileUtils.readFileToString(file));
        file.deleteOnExit();
    }
}
