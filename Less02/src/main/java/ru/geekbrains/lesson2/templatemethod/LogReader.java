package ru.geekbrains.lesson2.templatemethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Основа работы алгоритма чтения данных
 */
public abstract class LogReader {
    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Iterable<LogEntry> readLogEntry() {
        List<LogEntry> logEntryList = new ArrayList<>();
        for (String str : readEntries(currentPosition)) {
            logEntryList.add(parseLogEntry(str));
        }
        return logEntryList;
    }

    public abstract Object getDataSource();

    public abstract void setDataSource(Object data);

    protected abstract Iterable<String> readEntries(Integer position);

    protected abstract LogEntry parseLogEntry(String stringEntry);
}
