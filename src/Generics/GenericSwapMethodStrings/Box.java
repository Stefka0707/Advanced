package Generics.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();

    }

    public void addValue(T value) {
        this.values.add(value);
    }

    public void swap(int index1, int index2) {
        T firstElement = this.values.get(index1);

        this.values.set(index1, this.values.get(index2));
        this.values.set(index2, firstElement);


    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb
                    .append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());

        }
        // принтирането на последия елемент

        return sb.toString().trim();//trim ни маха последият ред след
    }
}

