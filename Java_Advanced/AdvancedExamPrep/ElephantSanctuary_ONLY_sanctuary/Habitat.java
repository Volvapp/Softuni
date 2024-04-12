package AdvancedMidExamPrep.ElephantSanctuary_ONLY_sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getAllElephants() {
        return data.size();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                data.remove(elephant);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        int age = 0;
        Elephant oldestElephant = null;
        for (Elephant elephant : data) {
            if (age < elephant.getAge()) {
                age = elephant.getAge();
                oldestElephant = elephant;
            }
        }
        return oldestElephant;
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
       report = new StringBuilder("Saved elephants in the park:\n");
        for (Elephant elephant : data) {
            String format = String.format("%BasicStackOperations came from: %BasicStackOperations", elephant.getName(), elephant.getRetiredFrom());
           report.append(format).append(System.lineSeparator());
        }
        return report.toString();
    }

}
