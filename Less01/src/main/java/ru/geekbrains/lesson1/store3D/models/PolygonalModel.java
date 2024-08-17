package ru.geekbrains.lesson1.store3D.models;

import java.util.List;

public class PolygonalModel {
    private static int counter = 70;
    private int id;
    private List<Polygon> polygons;
    private List<Texture> textures;

    {
        id = ++counter;
    }

    public PolygonalModel(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public PolygonalModel(List<Polygon> polygons, List<Texture> textures) {
        this.polygons = polygons;
        this.textures = textures;
    }

    public int getId() {
        return id;
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public List<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return "\n    PolygonalModel {" +
                "id= " + id +
                ",\n     polygons=" + polygons +
                ",\n     textures=" + textures +
                '}';
    }
}
