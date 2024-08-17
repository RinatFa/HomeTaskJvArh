package ru.geekbrains.lesson1.store3D;

import ru.geekbrains.lesson1.store3D.inmemory.ModelStore;
import ru.geekbrains.lesson1.store3D.inmemory.Observer1;
import ru.geekbrains.lesson1.store3D.inmemory.Observer2;
import ru.geekbrains.lesson1.store3D.models.Polygon;
import ru.geekbrains.lesson1.store3D.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        /**
         * Создать наблюдателей
         */
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        /**
         * Создать точки для полигонов
         */
        Point3D xyz1 = new Point3D(1, 2, 3);
        Point3D xyz2 = new Point3D(1, 3, 3);
        Point3D xyz3 = new Point3D(2, 3, 3);
        List<Point3D> point3DS1 = new ArrayList<>();
        point3DS1.add(xyz1);
        point3DS1.add(xyz2);
        point3DS1.add(xyz3);
        Point3D xyz4 = new Point3D(1, 0, 3);
        Point3D xyz5 = new Point3D(3, 0, 3);
        Point3D xyz6 = new Point3D(1, 2, 3);
        List<Point3D> point3DS2 = new ArrayList<>();
        point3DS2.add(xyz4);
        point3DS2.add(xyz5);
        point3DS2.add(xyz6);

        /**
         * Создать 2 полигона и текстуру
         */
        Polygon p1 = new Polygon(point3DS1);
        Polygon p2 = new Polygon(point3DS2);
        List<Polygon> polygons1 = new ArrayList<>();
        polygons1.add(p1);
        polygons1.add(p2);

        Texture t1 = new Texture("hatching");
        List<Texture> textures = new ArrayList<>();
        textures.add(t1);

        /**
         * Создать полигональную модель 1
         */
        PolygonalModel polygonalModel1 = new PolygonalModel(polygons1, textures);
        List<PolygonalModel> models1 = new ArrayList<>();
        models1.add(polygonalModel1);

        /**
         * Создать зеленый источник света 1 в начале координат в исходном положении
         */
        Point3D xyz7 = new Point3D(0, 0, 0);
        Angle3D angl1 = new Angle3D(0, 0);
        Color color1 = new Color(0, 255, 0);
        Flash flash1 = new Flash(xyz7, angl1, color1, 30.0f);
        List<Flash> flashes1 = new ArrayList<>();
        flashes1.add(flash1);

        /**
         * Создать камеру 1 в начале координат в исходном положении
         */
        Point3D xyz8 = new Point3D(0, 0, 0);
        Angle3D angl2 = new Angle3D(0, 0);
        Camera cam1 = new Camera(xyz8, angl2);
        List<Camera> cameras1 = new ArrayList<>();
        cameras1.add(cam1);

        /**
         * Создать сцену 1
         */
        Scene scene1 = new Scene(models1, flashes1, cameras1);
        List<Polygon> polygons2 = new ArrayList<>();
        PolygonalModel polygonalModel2 = new PolygonalModel(polygons2);
        scene1.add(polygonalModel2);

        /**
         * Создать общие коллекции полигональных моделей, сцен,
         * источников света и камер
         * Хранилище должно содержать минимум по 1 элементу
         * в каждой коллекции
         */
        List<PolygonalModel> models = new ArrayList<>();
        models.add(polygonalModel1);
        List<Scene> scenes = new ArrayList<>();
        scenes.add(scene1);
        List<Flash> flashes = new ArrayList<>();
        flashes.add(flash1);
        List<Camera> cameras = new ArrayList<>();
        cameras.add(cam1);

        /**
         * Создать хранилище и зарегистрировать наблюдателей
         */
        ModelStore modelStore = new ModelStore(models, scenes, flashes, cameras);
        System.out.println();
        modelStore.RegisterModelChanger(observer1);
        modelStore.RegisterModelChanger(observer2);

        /**
         * Создать отдельную полигональную модель с текстурой
         */
        Point3D xyz9 = new Point3D(4, 0, 2);
        Point3D xyz10 = new Point3D(5, 5, 2);
        Point3D xyz11 = new Point3D(6, 0, 2);
        List<Point3D> point3DS3 = new ArrayList<>();
        point3DS3.add(xyz9);
        point3DS3.add(xyz10);
        point3DS3.add(xyz11);
        Polygon p3 = new Polygon(point3DS3);
        List<Polygon> polygons3 = new ArrayList<>();
        polygons3.add(p3);
        PolygonalModel polygonalModel3 = new PolygonalModel(polygons3, textures);
        modelStore.add(polygonalModel3);

        /**
         * Добавить отдельный синий источник света 2 с перемещением и наклоном
         */
        Point3D xyz14 = new Point3D(1, 10, 8);
        Angle3D angl5 = new Angle3D(280, -45);
        Color color2 = new Color(0, 0, 255);
        Flash flash2 = new Flash(xyz14, angl5, color2, 35.0f);
        modelStore.add(flash2);

        /**
         * Разместить источник света и камеру.
         * Вывести объекты хранилища.
         */
        System.out.println("    (в хранилище добавлена полигональная модель" +
                " PolygonalModel с id= " + polygonalModel3.getId() + ")");
        System.out.println("    (в хранилище добавлен источник света" +
                " Flash с id= " + flash2.getId() + ")");
        System.out.println("    (на сцену добавлена пустая без текстуры" +
                " полигональная модель с id= " + polygonalModel2.getId() + ")");
        Point3D xyz12 = new Point3D(10, 10, 8);
        Angle3D angl3 = new Angle3D(215, -45);
        flash1.Move(xyz12);
        flash1.Rotate(angl3);
        Point3D xyz13 = new Point3D(10, 5, 12);
        Angle3D angl4 = new Angle3D(235, -30);
        cam1.Move(xyz13);
        cam1.Rotate(angl4);
        System.out.println();
        System.out.println("*** Вывод всего хранилища:");
        System.out.println("Xранилище: " + modelStore.toString());
        System.out.println();
        System.out.print("*** Вывод первой сцены:");
        System.out.println(modelStore.GetScene(0).toString());
        System.out.println();

        /**
         * Удалить наблюдателей
         */
        modelStore.RemoveModelChanger(observer1);
        modelStore.RemoveModelChanger(observer2);
    }
}
