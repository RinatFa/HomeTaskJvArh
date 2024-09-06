package ru.geekbrains.lesson5.Layer1;

import ru.geekbrains.lesson5.Entity;
import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.ProjectFile;
import ru.geekbrains.lesson5.Texture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Database
 */
public class EditorDatabase implements Database {
    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры и т. д)
    }

    @Override
    public void save() {
        //TODO: Сохранение текущего состояния всех сущностей проекта
    }

    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }

    public void addModelAndTextures() {
        if (entities != null) {
            generateModelAndTextures();
        }
    }

    @Override
    public void delModel(Model3D model3D) {
        if (entities != null) {
            entities.remove(model3D);
        }
    }

    @Override
    public void delTextures(Texture texture) {
        if (entities != null) {
            entities.remove(texture);
        }
    }
}
