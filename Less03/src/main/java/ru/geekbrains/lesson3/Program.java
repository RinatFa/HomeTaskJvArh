package ru.geekbrains.lesson3;

import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     * <p>
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     * <p>
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     * <p>
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     * <p>
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     * <p>
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     * <p>
     * <p>
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     * <p>
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     * <p>
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     * <p>
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println();
        Harvester harvester = new Harvester("Sаmangan", "CHD5021TLS", Color.ORANGE);
        System.out.println("Уборочный " + harvester.toString() + "оранжевый");
        System.out.println("   заехал на заправочную станцию № 1:");
        RefuelingStation refuelingStation = new RefuelingStation();
        harvester.setRefuelingStation(refuelingStation);
        harvester.setFuelType(FuelType.Diesel);
        harvester.fuel();
        System.out.println("   заехал на мойку № 1:");
        RewipingStation rewipingStation = new RewipingStation();
        harvester.setRewipingStation(rewipingStation);
        harvester.wipMirrors();
        harvester.wipWindshield();
        harvester.wipHeadlights();

        Volvo volvo = new Volvo("Volvo", "XC90", Color.BLACK);
        System.out.println("Легковой " + volvo.toString() + "черный");
        System.out.println("   заехал на заправочную станцию № 2:");
        RefuelingStationV2 refuelingStationV2 = new RefuelingStationV2();
        volvo.setRefuelingStation(refuelingStationV2);
        volvo.setFuelType(FuelType.Gasoline);
        volvo.fuel();

        System.out.println("   заехал на мойку № 2:");
        RewipingStationV2 rewipingStationV2 = new RewipingStationV2();
        volvo.setRewipingStation(rewipingStationV2);
        volvo.wipMirrors();
        volvo.wipWindshield();
        volvo.wipHeadlights();

        KAMAZ kamaz = new KAMAZ("КАМАЗ", "5490", Color.GREEN);
        System.out.println("Грузовой " + kamaz.toString() + "зеленый");
        System.out.println("   заехал на заправочную станцию № 1:");
        kamaz.setRefuelingStation(refuelingStation);
        kamaz.setFuelType(FuelType.Diesel);
        kamaz.fuel();
        System.out.println("   заехал на мойку № 1:");
        kamaz.setRewipingStation(rewipingStation);
        kamaz.wipMirrors();
        kamaz.wipWindshield();
        kamaz.wipHeadlights();

    }

    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6) {
            return 1500 * 6;
        } else {
            return 1000 * 4;
        }
    }
}
