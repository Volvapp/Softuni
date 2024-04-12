package LabEncapsulation.SalaryIncrease;

public class Person {
    private int age;
    private String firstName;
    private String lastName;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {

        if (getAge() > 30) {
            setSalary(getSalary() + getSalary() * bonus / 100);
        } else {
            setSalary(getSalary() + getSalary() * (bonus / 200));
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva.", getFirstName(), getLastName(), getSalary());
    }
}
