package ru.geekbrains.lesson2.adaptermethod;

/**
 * Программа для имитации подключения к USB
 * и копирования данных с карты памяти
 */
public class Program {
    public static void main(String[] args) {
        System.out.println();
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();
    }
}
