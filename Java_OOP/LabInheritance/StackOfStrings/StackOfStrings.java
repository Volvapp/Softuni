package LabInheritance.StackOfStrings;


import java.util.ArrayList;


public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (!data.isEmpty()){
            return this.data.remove(data.size() - 1);
        }
        return null;
    }

    public String peek() {
        if (!data.isEmpty()){
            return this.data.get(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

}
