package AdvancedExamPrep.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (this.getCapacity() > data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present currentPresent : data) {
            if (currentPresent.getName().equals(name)) {
                this.data.remove(currentPresent);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        Present heaviestPresent = new Present();
        for (Present present : data) {
            if (heaviestPresent.getWeight() < present.getWeight()) {
                heaviestPresent = present;
            }
        }
        return heaviestPresent;
    }

    public Present getPresent(String name) {
        for (Present currentPresent : data) {
            if (currentPresent.getName().equals(name)) {
                return currentPresent;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder(this.getColor() + " bag contains:").append(System.lineSeparator());
        for (Present currentPresent : data) {
            sb.append(currentPresent).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
