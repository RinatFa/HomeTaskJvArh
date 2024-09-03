package ru.geekbrains.lesson4.task3;

public class PaymentProvider implements IPayProvider {
    public boolean buyTicket(int orderId, String cardNo, double amount) {
        //TODO: Обращение к платежному шлюзу,
        // попытка выполнить списание средств ...

        if ((orderId > 7000000) &&
                (cardNo == "11000000221" || cardNo == "11000001012")
                && (amount == 45.0)) {
            return true;
        }
        return false;
    }
}
