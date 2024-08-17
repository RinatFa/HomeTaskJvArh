package ru.geekbrains.lesson1.store3D.models;

import java.util.List;

public class Polygon {
    private static int counter = 50;
    private int id;
    private List<Point3D> points;

    {
        id = ++counter;
    }

    public Polygon(List<Point3D> points) {
        this.points = points;
    }

    public Polygon() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n      Polygon {" +
                "id= " + id +
                ", points= " + points +
                '}';
    }
}
