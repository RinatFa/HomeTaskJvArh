package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogReader;

public abstract class BaseLogReaderCreator {
    private int currPos = 0;

    /**
     * Создание логера определенного типа.
     * Выполнение подготовительных действий
     * например, передать данные для инициализации
     */
    protected LogReader createLogReader(LogType logType, Object data, int currPos) {
        LogReader logReader = createLogReaderInstance(logType);
        logReader.setDataSource(data);
        logReader.setCurrentPosition(currPos);

        return logReader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);
}
