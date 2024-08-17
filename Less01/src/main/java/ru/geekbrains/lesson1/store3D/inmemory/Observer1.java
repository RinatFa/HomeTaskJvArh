package ru.geekbrains.lesson1.store3D.inmemory;

public class Observer1 implements ModelChangedObserver {
    @Override
    public void applyUpdateModel(int id) {
        System.out.println("Была добавлена" +
                " новая полигональная модель с id= " + id + " - observer1");
    }

    @Override
    public void applyUpdateFlash(int id) {
    }

    @Override
    public String toString() {
        return "Observer1";
    }
}
