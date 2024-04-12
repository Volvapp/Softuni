package EncapsulationExercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }


    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());

        } else {
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
            this.money -= product.getCost();
            products.add(product);
        }

    }

    public String getName() {
        return name;
    }
}
