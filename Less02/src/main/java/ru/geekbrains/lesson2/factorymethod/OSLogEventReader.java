package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OSLogEventReader extends LogReader {
    private String textOSLogEvent;

    public OSLogEventReader() {
    }

    public OSLogEventReader(String textOSLogEvent) {
        this.textOSLogEvent = textOSLogEvent;
    }

    @Override
    public Object getDataSource() {
        return textOSLogEvent;
    }

    @Override
    public void setDataSource(Object textOSLogEvent) {
        this.textOSLogEvent = textOSLogEvent.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(textOSLogEvent);
        List<String> textOSLogEventList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if (counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                textOSLogEventList.add(line);
            } else {
                scanner.nextLine();
            }
        }
        return textOSLogEventList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
