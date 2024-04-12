package AdvancedMidExamPrep.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (Rabbit currentRabbit : data) {

            if (currentRabbit.getName().equals(name)) {
                data.remove(currentRabbit);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (Rabbit currentRabbit : data) {
            if (currentRabbit.getSpecies().equals(species)) {
                data.remove(currentRabbit);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit currentRabbit : data) {
            if (currentRabbit.getName().equals(name)) {
                currentRabbit.setAvailable(false);
                return currentRabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitSpecies = new ArrayList<>();
        for (Rabbit currentRabbit : data) {
            if (currentRabbit.getSpecies().equals(species)) {
                currentRabbit.setAvailable(false);
                rabbitSpecies.add(currentRabbit);
            }
        }
        return rabbitSpecies;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Rabbit available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Rabbit currentRabbit : data) {
            if (currentRabbit.isAvailable()){
                sb.append(currentRabbit).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
