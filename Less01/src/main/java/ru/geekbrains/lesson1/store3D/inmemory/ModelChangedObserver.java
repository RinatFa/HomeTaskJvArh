package ru.geekbrains.lesson1.store3D.inmemory;

public interface ModelChangedObserver {
    void applyUpdateModel(int id);

    void applyUpdateFlash(int id);
}
