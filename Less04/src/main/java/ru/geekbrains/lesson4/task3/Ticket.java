package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;

/**
 * Билет
 */
public class Ticket {
    private static int counterT = 579010;
    private int id;
    private int customerId;
    private LocalDate date;
    private String qrcode;
    private boolean enable = true;

    {
        id = ++counterT;
    }

    public Ticket() {
    }

    public Ticket(int customerId, LocalDate date, String qrcode) {
        this.customerId = customerId;
        this.date = date;
        this.qrcode = qrcode;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "\n  Ticket " +
                "id= " + id +
                ", customerId= " + customerId +
                ", date= " + date +
                ", qrcode= '" + qrcode + '\'' +
                ", enable= " + enable;
    }
}
