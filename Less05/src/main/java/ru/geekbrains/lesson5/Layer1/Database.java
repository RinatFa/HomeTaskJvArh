package ru.geekbrains.lesson5.Layer1;

import ru.geekbrains.lesson5.Entity;
import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.Texture;

import java.util.Collection;

/**
 * Интерфейс БД
 */
public interface Database {
    void load();

    void save();

    Collection<Entity> getAll();

    void addModelAndTextures();

    void delModel(Model3D model3D);

    void delTextures(Texture texture);
}
