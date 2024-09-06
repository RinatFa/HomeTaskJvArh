package ru.geekbrains.lesson5.Layer2;

import ru.geekbrains.lesson5.Entity;
import ru.geekbrains.lesson5.Layer1.Database;
import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.Texture;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Реализация DAC
 */
public class EditorDatabaseAccess implements DatabaseAccess {
    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                models.add((Texture) entity);
            }
        }
        return models;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public void addModelAndTextures() {
        editorDatabase.addModelAndTextures();
    }

    @Override
    public void delModel(Model3D model3D) {
        editorDatabase.delModel(model3D);
    }

    @Override
    public void delTextures(Texture texture) {
        editorDatabase.delTextures(texture);
    }
}
