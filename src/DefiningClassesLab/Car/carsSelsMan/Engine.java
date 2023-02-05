package DefiningClassesExercise.carsSelsMan;

public class Engine {


    private String model;
    private int power;
    private int displacement;// работен обем на двигателя
    private String efficiency;//ефективност

    public Engine(String model, int power, int displacement, String efficiency) {

        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
