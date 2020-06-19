package com.envy.application.fileReader;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Reader {
    private static final String USER_FILE_PATH = "input/data.txt";
    private static final String DEFAULT_FILE_PATH = "input/default.txt";

    public List<String> readFile(boolean useDefault) throws IOException {
        Path path;
        if (useDefault) {
            path = Paths.get(DEFAULT_FILE_PATH);
        }
        else {
            path = Paths.get(USER_FILE_PATH);
            if (!Files.exists(path)) {
                path = Paths.get(DEFAULT_FILE_PATH);
            }
        }
        List<String> data;
        try {
            data = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IOException("Error while reading file", e);
        }
        return data;
    }
}
