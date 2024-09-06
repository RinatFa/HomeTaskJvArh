package ru.geekbrains.lesson5.Layer3;

import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.Texture;

import java.util.Collection;

/**
 * Интерфейс BLL (Business Logical Layer)
 */
public interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    void addModelAndTextures();

    void delModel(Model3D model3D);

    void delTextures(Texture texture);
}
