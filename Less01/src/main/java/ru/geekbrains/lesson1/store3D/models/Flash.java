package ru.geekbrains.lesson1.store3D.models;

import java.awt.*;

public class Flash {
    private static int counter = 80;
    private int id;
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private float Power;

    {
        id = ++counter;
    }

    public Flash(Point3D location, Angle3D angle, Color color, float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        Power = power;
    }

    public Flash() {
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public float getPower() {
        return Power;
    }

    public int getId() {
        return id;
    }

    public void Move(Point3D location) {
        setLocation(location);
        System.out.println("*** Перемещен источник света в точку: " +
                location);
    }

    public void Rotate(Angle3D angle) {
        setAngle(angle);
        System.out.println("*** Наклонен источник света на углы: " +
                angle);
    }

    @Override
    public String toString() {
        return "\n    Flash {" +
                "id= " + id +
                ", location=" + location +
                ", angle=" + angle +
                ",\n      color=" + color +
                ", Power=" + Power +
                '}';
    }
}
