package ru.geekbrains.lesson1.store3D.models;

public class Angle3D {
    private double azi, seat_angle;

    public Angle3D(double azi, double seat_angle) {
        this.azi = azi;
        this.seat_angle = seat_angle;
    }

    public double getAzi() {
        return azi;
    }

    public void setAzi(double azi) {
        this.azi = azi;
    }

    public double getSeat_angle() {
        return seat_angle;
    }

    public void setSeat_angle(double seat_angle) {
        this.seat_angle = seat_angle;
    }

    @Override
    public String toString() {
        return "Angle3D {" +
                "azi=" + azi +
                ", seat_angle=" + seat_angle +
                '}';
    }
}
