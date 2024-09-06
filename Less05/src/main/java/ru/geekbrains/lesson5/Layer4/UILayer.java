package ru.geekbrains.lesson5.Layer4;

/**
 * Интерфейс UI
 */
public interface UILayer {
    void openProject(String fileName);

    void saveProject();

    void showProjectSettings();

    void printAllModels();

    void printAllTextures();

    void renderModel(int i);

    void renderAll();

    void addModelAndTextures();

    void delModelAndTextures();
}
