package ru.geekbrains.lesson4.task3;

/**
 * Автобусная станция
 */
public class BusStation {
    ITickProvider tickProviderI;

    public BusStation(ITickProvider tickProviderI) {
        this.tickProviderI = tickProviderI;
    }

    public boolean checkTicket(String qrCode) {
        return tickProviderI.checkTicket(qrCode);
    }
}
