package ru.geekbrains.lesson1.store3D.models;

public class Texture {
    private static int counter = 10;
    private int id;

    private String name;

    {
        id = ++counter;
    }

    public Texture(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Texture {" +
                "id= " + id +
                ", name='" + name + '\'' +
                '}';
    }
}
