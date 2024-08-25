package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

public class Program {
    public static String data = """
            У лукоморья дуб зелёный;
            Златая цепь на дубе том:
            И днём и ночью кот учёный
            Всё ходит по цепи кругом;
            Идёт направо — песнь заводит,
            Налево — сказку говорит.""";
    public static String textfile = """
            Первая строка текстового файла
            Вторая строка текстового файла
            Третья строка текстового файла""";
    public static String textDB = """
            Первая строка текста из базы данных
            Вторая строка текста из базы данных
            Третья строка текста из базы данных""";
    public static String textOSLogEvent = """
            Первая строка лога событий операционной системы
            Вторая строка лога событий операционной системы
            Третья строка  лога событий операционной системы""";

    public static void main(String[] args) {
        LogReader logReaderPoem = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem, data, 5);
        LogReader logReaderText = new ConcreteReaderCreator()
                .createLogReader(LogType.Text, textfile, 1);
        LogReader logReaderDatabase = new ConcreteReaderCreator()
                .createLogReader(LogType.Database, textDB, 2);
        LogReader logReaderSystem = new ConcreteReaderCreator()
                .createLogReader(LogType.System, textOSLogEvent, 3);

        System.out.println();
        for (LogEntry log : logReaderPoem.readLogEntry()) {
            System.out.println(log.getText());
        }
        System.out.println();
        for (LogEntry log : logReaderText.readLogEntry()) {
            System.out.println(log.getText());
        }
        System.out.println();
        for (LogEntry log : logReaderDatabase.readLogEntry()) {
            System.out.println(log.getText());
        }
        System.out.println();
        for (LogEntry log : logReaderSystem.readLogEntry()) {
            System.out.println(log.getText());
        }
    }
}
