package ru.geekbrains.lesson4.task3;

public class Core {
    IDatabase databaseI;
    ICustProvider custProviderI;
    IPayProvider payProviderI;
    ITickProvider tickProviderI;

    public Core() {
        databaseI = new Database();
        custProviderI = new CustomerProvider(databaseI);
        payProviderI = new PaymentProvider();
        tickProviderI = new TicketProvider(databaseI, payProviderI);
    }

    public ICustProvider getCustProviderI() {
        return custProviderI;
    }

    public ITickProvider getTickProviderI() {
        return tickProviderI;
    }

    @Override
    public String toString() {
        return databaseI.toString();
    }
}
