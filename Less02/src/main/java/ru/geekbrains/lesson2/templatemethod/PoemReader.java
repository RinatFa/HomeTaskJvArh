package ru.geekbrains.lesson2.templatemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс реализует примитивные шаги алгоритма
 */
public class PoemReader extends LogReader {
    private String data;

    public PoemReader() {
    }

    public PoemReader(String data) {
        this.data = data;
    }

    @Override
    public Object getDataSource() {
        return data;
    }

    @Override
    public void setDataSource(Object data) {
        this.data = data.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(data);
        List<String> poemList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if (counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                poemList.add(line);
            } else {
                scanner.nextLine();
            }
        }
        return poemList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
