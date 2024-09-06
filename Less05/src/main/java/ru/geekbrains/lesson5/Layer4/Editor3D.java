package ru.geekbrains.lesson5.Layer4;

import ru.geekbrains.lesson5.Layer1.Database;
import ru.geekbrains.lesson5.Layer1.EditorDatabase;
import ru.geekbrains.lesson5.Layer2.DatabaseAccess;
import ru.geekbrains.lesson5.Layer2.EditorDatabaseAccess;
import ru.geekbrains.lesson5.Layer3.BusinessLogicalLayer;
import ru.geekbrains.lesson5.Layer3.EditorBusinessLogicalLayer;
import ru.geekbrains.lesson5.Model3D;
import ru.geekbrains.lesson5.ProjectFile;
import ru.geekbrains.lesson5.Texture;

import java.util.ArrayList;

/**
 * UI (User Interface)
 */
public class Editor3D implements UILayer {
    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    private void checkProjectFile() {
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }

    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        database.save();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)
                businessLogicalLayer.getAllModels();
        if (models.size() > 0) {
            for (int i = 0; i < models.size(); i++) {
                System.out.printf("=== 3D модель № %d ===\n", i + 1);
                System.out.println(models.get(i));
                for (Texture texture : models.get(i).getTextures()) {
                    System.out.printf("\t%s\n", texture);
                }
            }
        } else {
            System.out.println("\tВ проекте нет 3D моделей!");
        }
    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)
                businessLogicalLayer.getAllTextures();
        if (textures.size() > 0) {
            for (int i = 0; i < textures.size(); i++) {
                System.out.printf("=== текстура № %d ===\n", i + 1);
                System.out.println(textures.get(i));
            }
        } else {
            System.out.println("\tВ проекте нет текстур!");
        }
    }

    @Override
    public void renderModel(int i) {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)
                businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void renderAll() {

        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void addModelAndTextures() {

        // Предусловие
        checkProjectFile();

        businessLogicalLayer.addModelAndTextures();
        ArrayList<Model3D> models = (ArrayList<Model3D>)
                businessLogicalLayer.getAllModels();
        System.out.printf("Добавлена %d-я модель:\n  ", models.size());
        System.out.printf("=== 3D модель № %d ===\n", models.size());
        System.out.println(models.get(models.size() - 1).toString());
        boolean bText = true;
        for (Texture texture : models.get(models.size() - 1).getTextures()) {
            if (bText) {
                System.out.println("  и текстуры:");
                bText = false;
            }
            System.out.printf("\t%s\n", texture);
        }


    }

    @Override
    public void delModelAndTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)
                businessLogicalLayer.getAllModels();
        if (models.size() > 0) {
            businessLogicalLayer.delModel(models.get(models.size() - 1));
            System.out.printf("Удалена %d-я модель:\n  ", models.size());
            for (Texture texture : models.get(models.size() - 1).getTextures()) {
                System.out.printf("\tудалена %s\n", texture);
                businessLogicalLayer.delTextures(texture);
            }
        } else {
            System.out.println("\tВ проекте нет 3D моделей и текстур!");
        }
    }
}
