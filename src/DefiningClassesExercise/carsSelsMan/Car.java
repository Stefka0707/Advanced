package DefiningClassesExercise.carsSelsMan;


public class Car {

    private String model;//не пречи в различни класове да има fields с еднакви имена

    private Engine engine;// тука прикрепяме обект от класа Engine

    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").
                append(System.lineSeparator());
        sb.append(this.engine.getModel()).append(":").//engin.getModel ->защото го извиква от класа Engin
                append(System.lineSeparator());
        // за да можем да досъпваме полета от клас Engin
        //трябва там да сме генерирали гетер
        sb.append("Power: ").append(this.engine.getPower()).
                append(System.lineSeparator());
        sb.append("Displacement: ");
// на Displacement Внимаваме , 
// защото или го няма и е 0 
// ако го има е цяло число 
        if (this.engine.getDisplacement() == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }
        sb.append("Efficiency: ");
        if (this.engine.getEfficiency() == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }
        sb.append("Weight: ");
        if (this.weight == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.weight).append(System.lineSeparator());
        }
        sb.append("Color: ");
        if (this.color == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.color).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
