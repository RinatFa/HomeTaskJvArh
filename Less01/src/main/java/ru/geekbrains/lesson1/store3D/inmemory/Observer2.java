package ru.geekbrains.lesson1.store3D.inmemory;

public class Observer2 implements ModelChangedObserver {
    @Override
    public void applyUpdateModel(int id) {
    }

    @Override
    public void applyUpdateFlash(int id) {
        System.out.println("Был добавлен" +
                " новый источник света с id= " + id + " - observer2");
    }

    @Override
    public String toString() {
        return "Observer2";
    }
}
