package ru.geekbrains.lesson5.Layer2;

import ru.geekbrains.lesson5.Entity;
import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.Texture;

import java.util.Collection;

/**
 * Интерфейс DAC
 */
public interface DatabaseAccess {
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    void addModelAndTextures();

    void delModel(Model3D model3D);

    void delTextures(Texture texture);
}
