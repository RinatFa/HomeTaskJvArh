package ru.geekbrains.lesson1.store3D.inmemory;

public interface IModelChanger {
    /**
     * Произошло изменение в хранилище моделей
     */
    void notifyChange(int id);

    void notifyChange2(int id);

    void RegisterModelChanger(ModelChangedObserver o);

    void RemoveModelChanger(ModelChangedObserver o);
}
