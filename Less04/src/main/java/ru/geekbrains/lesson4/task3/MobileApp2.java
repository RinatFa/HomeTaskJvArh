package ru.geekbrains.lesson4.task3;

public class MobileApp2 extends MobileApp {
    public MobileApp2(ICustProvider custProviderI, ITickProvider tickProviderI) {
        super(custProviderI, tickProviderI);
    }

    @Override
    public boolean buyTicket() {
        String cardNo = "11000001012";
        return tickProviderI.buyTicket(customerI.getId(), cardNo);
    }
}
