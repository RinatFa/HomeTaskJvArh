package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.Layer4.Editor3D;

import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * <p>
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок
     * редактирования, блок просмотра).
     * Какие задачи можно делать – функции системы? (Загрузить 3D модель,
     * рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация ..,
     * в файловой системе компьютера).
     * <p>
     * Предложить варианты связывания всех уровней – сценарии использования.
     * 3-4 сценария.
     * Сквозная функция – создать новую 3D модель, сделать рендер для печати
     * на принтере…
     */
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер модели");
            System.out.println("7. Выполнить рендер всех моделей");
            System.out.println("8. Добавить модель и текстуры к ней с наибольшими номерами");
            System.out.println("9. Удалить модель и текстуры к ней с наибольшими номерами");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.print(
                                    "Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println(
                                        "Номер модели указан некорректно.");
                            }
                            break;
                        case 7:
                            editor3D.renderAll();
                            break;
                        case 8:
                            editor3D.addModelAndTextures();
                            break;
                        case 9:
                            editor3D.delModelAndTextures();
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
}
