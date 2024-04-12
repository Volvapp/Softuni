package MidExam.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() + 1 <= capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport() {
        List<Child> childrenSorted = registry.stream().sorted(Comparator.comparing(Child::getLastName))
                .sorted(Comparator.comparing(Child::getFirstName))
                .sorted(Comparator.comparingInt(Child::getAge))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("Registered children in ").append(this.name).append(":").append(System.lineSeparator());

        for (Child child : childrenSorted) {
            sb.append("--").append(System.lineSeparator());
            sb.append(String.format("%s%n", child.toString()));
        }
        return sb.toString();
    }
}
