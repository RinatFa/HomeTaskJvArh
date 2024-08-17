package ru.geekbrains.lesson1.store3D.models;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private static int counter = 100;
    private int id;
    private List<PolygonalModel> models;
    private List<Flash> flashes = new ArrayList<>();
    private List<Camera> cameras;

    {
        id = ++counter;
    }

    public Scene(List<PolygonalModel> models, List<Flash> flashes,
                 List<Camera> cameras) {
        if (models == null || models.size() == 0) {
            throw new RuntimeException("Сцена должна содержать минимум одну модель.");
        }
        if (cameras == null || cameras.size() == 0) {
            throw new RuntimeException("Сцена должна содержать минимум одну камеру.");
        }
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    public Scene(List<PolygonalModel> models, List<Camera> cameras) {
        if (models == null || models.size() == 0) {
            throw new RuntimeException("Сцена должна содержать минимум одну модель.");
        }
        if (cameras == null || cameras.size() == 0) {
            throw new RuntimeException("Сцена должна содержать минимум одну камеру.");
        }
        this.models = models;
        this.cameras = cameras;
    }

    public void add(PolygonalModel model) {
        models.add(model);
    }

    @Override
    public String toString() {
        return "\n  Scene {" +
                "id= " + id +
                ",\n   models=" + models +
                ",\n   flashes=" + flashes +
                ",\n   cameras=" + cameras +
                '}';
    }
}
