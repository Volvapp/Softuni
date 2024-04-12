package DefiningClassesExercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;

    private Car car;

    private List<Parents> parents;

    private List<Children> children;

    private List<Pokemon> pokemonList;

    public Person () {

        this.parents = new ArrayList<>();

        this.children = new ArrayList<>();

        this.pokemonList = new ArrayList<>();
    }
    public Person(Company company, Car car, List<Parents> parents, List<Children> children, List<Pokemon> pokemonList) {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.children = children;
        this.pokemonList = pokemonList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public List<Pokemon> getPokemon() {
        return this.pokemonList;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }

        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemonList) {
            builder.append(pokemon).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Children child : children) {
            builder.append(child).append("\n");
        }

        return builder.toString();
    }
}