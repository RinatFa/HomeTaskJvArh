package ru.geekbrains.lesson1.store3D.inmemory;

import ru.geekbrains.lesson1.store3D.models.Camera;
import ru.geekbrains.lesson1.store3D.models.Flash;
import ru.geekbrains.lesson1.store3D.models.PolygonalModel;
import ru.geekbrains.lesson1.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    private List<ModelChangedObserver> observers = new ArrayList<>();
    private List<PolygonalModel> models = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    public ModelStore(List<PolygonalModel> models,
                      List<Scene> scenes,
                      List<Flash> flashes,
                      List<Camera> cameras) {
        if (models == null || models.size() == 0) {
            throw new RuntimeException(
                    "Хранилище должно содержать минимум одну модель.");
        }
        if (scenes == null || scenes.size() == 0) {
            throw new RuntimeException(
                    "Хранилище должно содержать минимум одну сцену.");
        }
        if (flashes == null || flashes.size() == 0) {
            throw new RuntimeException(
                    "Хранилище должно содержать минимум один источник света.");
        }
        if (cameras == null || cameras.size() == 0) {
            throw new RuntimeException(
                    "Хранилище должно содержать минимум одну камеру.");
        }
        this.models = models;
        this.scenes = scenes;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    public ModelStore() {
    }

    public void add(PolygonalModel model) {
        models.add(model);
        notifyChange(model.getId());
    }

    public void add(Scene scene) {
        scenes.add(scene);
    }

    public void add(Flash flash) {
        flashes.add(flash);
        notifyChange2(flash.getId());
    }

    public void add(Camera camera) {
        cameras.add(camera);
    }

    public Scene GetScene(int id) {
        return scenes.get(id);
    }

    @Override
    public void notifyChange(int id) {
        for (ModelChangedObserver observer : observers) {
            observer.applyUpdateModel(id);
        }
    }

    @Override
    public void notifyChange2(int id) {
        for (ModelChangedObserver observer : observers) {
            observer.applyUpdateFlash(id);
        }
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        observers.add(o);
        System.out.println("*** Наблюдатель " + o.toString() +
                " зарегистрирован!");
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        observers.remove(o);
        System.out.println("*** Наблюдатель " + o.toString() +
                " удален!");
    }

    @Override
    public String toString() {
        return "ModelStore {" +
                "\n models=" + models +
                ",\n scenes=" + scenes +
                ",\n flashes=" + flashes +
                ",\n cameras=" + cameras +
                '}';
    }
}
