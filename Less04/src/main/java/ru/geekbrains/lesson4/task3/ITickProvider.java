package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;
import java.util.Collection;

public interface ITickProvider {
    public Collection<Ticket> addTicket(int clientId, LocalDate date);

    public boolean buyTicket(int clientId, String cardNo);

    public boolean checkTicket(String qrcode);
}
