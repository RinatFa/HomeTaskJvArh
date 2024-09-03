package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Мобильное приложение
 */
public abstract class MobileApp {
    ICustomer customerI;
    ICustProvider custProviderI;
    ITickProvider tickProviderI;

    public MobileApp(ICustProvider custProviderI,
                     ITickProvider tickProviderI) {
        this.custProviderI = custProviderI;
        this.tickProviderI = tickProviderI;
        customerI = custProviderI.getCustomer(
                "<login>", "<password>");
    }

    public Collection<Ticket> getTickets() {
        return customerI.getTickets();
    }

    public void addTicket(LocalDate date) {
        customerI.setTickets(tickProviderI.addTicket(
                customerI.getId(), date));
    }

    public abstract boolean buyTicket();

    public int getCustomer() {
        return customerI.getId();
    }

    @Override
    public String toString() {
        return "MobileApp {" +
                "customer= " + customerI.getId() +
                '}';
    }
}
