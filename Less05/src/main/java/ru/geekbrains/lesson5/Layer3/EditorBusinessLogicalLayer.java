package ru.geekbrains.lesson5.Layer3;

import ru.geekbrains.lesson5.Layer2.DatabaseAccess;
import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.Texture;

import java.util.Collection;
import java.util.Random;

/**
 * Реализация Business Logical Layer
 */
public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {
    private Random random = new Random();
    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels())
            processRender(model);
    }

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addModelAndTextures() {
        databaseAccess.addModelAndTextures();
    }

    @Override
    public void delModel(Model3D model3D) {
        databaseAccess.delModel(model3D);
    }

    @Override
    public void delTextures(Texture texture) {
        databaseAccess.delTextures(texture);
    }
}
