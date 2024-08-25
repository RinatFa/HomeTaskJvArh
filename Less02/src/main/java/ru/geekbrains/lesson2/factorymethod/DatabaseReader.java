package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseReader extends LogReader {
    private String textDB;

    public DatabaseReader() {
    }

    public DatabaseReader(String textDB) {
        this.textDB = textDB;
    }

    @Override
    public Object getDataSource() {
        return textDB;
    }

    @Override
    public void setDataSource(Object textDB) {
        this.textDB = textDB.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(textDB);
        List<String> textDBList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if (counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                textDBList.add(line);
            } else {
                scanner.nextLine();
            }
        }
        return textDBList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
