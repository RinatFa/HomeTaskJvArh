package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TicketProvider implements ITickProvider {
    IDatabase databaseI;
    IPayProvider payProviderI;

    public TicketProvider(IDatabase databaseI, IPayProvider payProviderI) {
        this.databaseI = databaseI;
        this.payProviderI = payProviderI;
    }

    @Override
    public Collection<Ticket> addTicket(int clientId, LocalDate date) {
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : databaseI.getTickets()) {
            if (ticket.getCustomerId() == clientId &&
                    ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;
    }

    @Override
    public boolean buyTicket(int clientId, String cardNo) {
        int orderId = databaseI.createTicketOrder(clientId);
        double amount = databaseI.getTicketAmount();
        System.out.println("*** Покупатель " + clientId + " покупает билет - заказ: " + orderId +
                ", карта: " + cardNo + ", цена: " + amount);
        databaseI.addTicket(clientId, LocalDate.now(), clientId + "qrc");

        return payProviderI.buyTicket(orderId, cardNo, amount);
    }

    @Override
    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : databaseI.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                return true;
            }
        }
        return false;
    }
}
