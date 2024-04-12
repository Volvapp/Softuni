//package shelter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Shelter {
//    private List<Animal> data;
//    private int capacity;
//
//    public Shelter(int capacity) {
//        this.capacity = capacity;
//        this.data = new ArrayList<>();
//    }
//
//    public void add(Animal animal) {
//        if (capacity > data.size()) {
//            this.data.add(animal);
//        }
//    }
//
//    public boolean remove(String name) {
//        for (Animal animal : data) {
//            if (animal.getName().equals(name)) {
//                data.remove(animal);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Animal getAnimal(String name, String caretaker) {
//        for (Animal animal : data) {
//            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
//                return animal;
//            }
//        }
//        return null;
//    }
//
//    public Animal getOldestAnimal() {
//        Animal oldestAnimal = new Animal();
//        for (Animal animal : data) {
//
//            if (animal.getAge() > oldestAnimal.getAge()) {
//                oldestAnimal = animal;
//            }
//        }
//        return oldestAnimal;
//    }
//
//    public int getCount() {
//        return data.size();
//    }
//
//    public String getStatistics() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("The shelter has the following animals:").append(System.lineSeparator());
//        for (Animal animal : data) {
//            sb.append(animal.getName()).append(" ").append(animal.getCaretaker()).append(System.lineSeparator());
//        }
//        return sb.toString();
//    }
//}
