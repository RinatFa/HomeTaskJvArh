package ru.geekbrains.lesson4.task3;

public interface IPayProvider {
    boolean buyTicket(int orderId, String cardNo, double amount);
}
