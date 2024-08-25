package ru.geekbrains.lesson2.templatemethod;

/**
 * Запись лога
 */
public class LogEntry {
    private String text;

    public LogEntry(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
