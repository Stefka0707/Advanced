package DefiningClassesExercise.carsSelsMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Engine
        int enginesCount = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int engineCount = 1; engineCount <= enginesCount; engineCount++) {
            //за всеки един двигател получаваме данни
            // displacement and efficiency не се знае дали ще се въведат, защото не са задължителни
            String[] engineData = scanner.nextLine().split("\\s+");
            //required
            String model = engineData[0];
            //required
            int power = Integer.parseInt(engineData[1]);

            //optional
            int displacement = 0;
            // optional
            String efficiency = null;

            // и сега правим проверка дали са въведени или не последните две
            if (engineData.length == 4) {
                // displacement and efficiency са въведени и ги задаваме
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                // тук получаваме или
                // model,power, displacement->int
                //или
                //model,power, efficiency-> string
                // проверяваме
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];

                }
            }
            //model,power,displacement,efficiency
            Engine engine = new Engine(model, power, displacement, efficiency);
            // Добавяме двигателя в списъка
            //целия клас го добавяме -> Engine engine = new Engine(model, power, displacement, efficiency);

            engines.add(engine);
        }

        // Car
        int carsCount = Integer.parseInt(scanner.nextLine());

        for (int carCount = 1; carCount <= carsCount; carCount++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String enginModel = carData[1];
            // optional
            int weight = 0;
            String color = null;
            if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    weight = Integer.parseInt(carData[2]);

                } else {
                    color = carData[2];
                }
            }
            // трябва да проверим кой модел двигарел е въведен
            // за това горе при двигателите сме направили List<Engine>
            // там където е създатен класа Engine по- нагоре
            //добавяме двигателя в списъка
            //сега намираме двигателя по модела който имаме при carData
            // затова обхождаме с форийч всеки един двигател от класа Engine

            Engine carEngine = null;
            for (Engine engine : engines) {
                //за да достъпваме класа Engin поле model -> там
                //трябва да сме си направили geter;
                // при съвпадение казваме Engin carEngin = engine-т.р създаваме си обект,който е равен на обекта с който съвпада от класа Engin;
                if (enginModel.equals(engine.getModel())) {
                    //проверяваме дали моделът на дригателя,
                    //който принадлежи на голата съвпада двигател,който имаме  листа,който държи обекти двигатели
                    carEngine = engine;
                    break;
                }
            }
            //създаваме си вече кола,щом знаем кой е нейният двигател
            //не забравяме да си направим конструктор за да виждаме полетата и в клас Car

            Car car = new Car(carModel,carEngine,weight,color);
            System.out.print(car.toString());
        }

    }
}
