package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;
import java.util.Collection;

public class Program {
    /**
     * Разработать контракты и компоненты системы
     * "Покупка онлайн билетов на автобус в час пик".
     * <p>
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую
     * нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) {
        Core core = new Core();

        MobileApp1 mobileApp1 = new MobileApp1(core.getCustProviderI(),
                core.getTickProviderI());
        BusStation busStation = new BusStation(core.getTickProviderI());
        System.out.println();
        if (mobileApp1.buyTicket()) {
            System.out.print("Покупатель " + mobileApp1.getCustomer() +
                    " успешно купил билет:");
            mobileApp1.addTicket(LocalDate.now());

            Collection<Ticket> tickets = mobileApp1.getTickets();
            System.out.println(tickets);
            if (busStation.checkTicket(
                    tickets.stream().findFirst().get().getQrcode())) {
                System.out.println("Покупатель " + mobileApp1.getCustomer() +
                        " успешно прошел в автобус!");
            }
        } else {
            System.out.println("Покупатель не смог купить билет!");
        }

        MobileApp2 mobileApp2 = new MobileApp2(core.getCustProviderI(),
                core.getTickProviderI());
        System.out.println();
        if (mobileApp2.buyTicket()) {
            System.out.print("Покупатель " + mobileApp2.getCustomer() +
                    " успешно купил билет:");
            mobileApp2.addTicket(LocalDate.now());
            Collection<Ticket> tickets = mobileApp2.getTickets();
            System.out.println(tickets);
            if (busStation.checkTicket(
                    tickets.stream().findFirst().get().getQrcode())) {
                System.out.println("Покупатель " + mobileApp2.getCustomer() +
                        " успешно прошел в автобус!");
            }

        } else {
            System.out.println("Покупатель не смог купить билет!");
        }
        System.out.println();
        System.out.println("*** Все билеты в БД (уже не действующие или" +
                " еще действующие) и покупатели \n" +
                "(купившие билеты или попытавшиеся купить " +
                "(ошибка в наборе номера карты)): "
                + core.toString());
    }
}
