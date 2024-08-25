package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader extends LogReader {
    private String textfile;

    public TextFileReader() {
    }

    public TextFileReader(String textfile) {
        this.textfile = textfile;
    }

    @Override
    public Object getDataSource() {
        return textfile;
    }

    @Override
    public void setDataSource(Object textfile) {
        this.textfile = textfile.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(textfile);
        List<String> textFileList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if (counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                textFileList.add(line);
            } else {
                scanner.nextLine();
            }
        }
        return textFileList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
