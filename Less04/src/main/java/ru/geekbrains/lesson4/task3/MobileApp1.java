package ru.geekbrains.lesson4.task3;

public class MobileApp1 extends MobileApp {
    public MobileApp1(ICustProvider custProviderI, ITickProvider tickProviderI) {
        super(custProviderI, tickProviderI);
    }

    @Override
    public boolean buyTicket() {
        String cardNo = "11000000221";
        return tickProviderI.buyTicket(customerI.getId(), cardNo);
    }
}
