package SOLID.logger.appenders;

import SOLID.logger.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private static final String DEFAULT_FILE_NAME = "errorReports.txt";

    private StringBuilder stringBuilder;
    private int textSize;
    private String fileName;

    public LogFile(String fileName) {
        this.stringBuilder = new StringBuilder();
        this.textSize = 0;
        this.fileName = fileName;
    }

    public LogFile() {
        this(DEFAULT_FILE_NAME);
    }

    @Override
    public int getSize() {
        return this.calculateTextSize();
    }

    private int calculateTextSize() {
        int size = 0;

        for (char letter : this.stringBuilder.toString().toCharArray()) {
            if(Character.isAlphabetic(letter)) {
                size += letter;
            }
        }
        return size;
    }

    @Override
    public void append(String text) {
        stringBuilder.append(text);
        this.write(text);

    }

    @Override
    public boolean write(String text) {
        try {
            Files.write(Paths.get(this.fileName), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
