package DefiningClassesLab.Car;

import java.util.Objects;

public class Car {
    //we initialize fields

    //we initialize fields

    private String brand;
    private String model;
    private int horsePower;

    public  Car(String brand){
        this(brand,"unknown",-1);

    }
    // Горния конструктое извиква долния
    // но трябва да се запази сигнатурата
    //а в горния ще получим само един параметър за вход
    // сетваме останалите параметри с техните default стойности
    public Car(String brand, String model, int horsePower) {
        this. brand = brand;
        this. model = model;
        this. horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),getHorsePower());
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        DefiningClassesLab.Car.Car car = (DefiningClassesLab.Car.Car) o;
//        return horsePower == car.horsePower && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }
}

