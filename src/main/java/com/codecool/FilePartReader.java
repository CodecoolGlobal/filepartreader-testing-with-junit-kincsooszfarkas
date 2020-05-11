package com.codecool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public void setUp(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine should be greater than fromLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine should be greater than 1");
        }
        this.filePath = filePath;
    }

    public String read() throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
    }

    public String readLines() throws IOException {
        String content = read();
        String[] lines = content.split("\\r?\\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = fromLine - 1; i < toLine; i++) {
            stringBuilder.append(lines[i]);
        }
        return stringBuilder.toString();
    }
}
