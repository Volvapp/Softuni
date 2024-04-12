import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("softuni_jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        //ex2(entityManager);
        //ex3(entityManager);
        //ex4(entityManager);
        //ex5(entityManager);
        //ex6(entityManager);
        //ex7(entityManager);
        //ex8(entityManager);
        //ex9(entityManager);
        //ex10(entityManager);
        //ex11(entityManager);
        //ex12(entityManager);
        //ex13(entityManager);
        entityManager.getTransaction().commit();
    }

    private static void ex13(EntityManager entityManager) throws IOException {
        List<Town> resultList = entityManager.createQuery("FROM Town WHERE name = :name", Town.class)
                .setParameter("name", READER.readLine())
                .getResultList();

        if (!resultList.isEmpty()) {
            Town town = resultList.get(0);
            List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a JOIN a.town t WHERE t.name = :name", Address.class)
                    .setParameter("name", town.getName())
                    .getResultList();
            addresses.forEach(a -> {
                a.getEmployees().forEach(employee -> {
                    employee.setAddress(null);
                    entityManager.persist(employee);
                });
                entityManager.remove(a);
            });

            System.out.printf("%d addresses in %s deleted.", addresses.size(), town.getName());
            entityManager.remove(town);
        }
        return;
    }

    private static void ex12(EntityManager entityManager) {
        String fromDepartment = entityManager.createQuery("FROM Department ", Department.class)
                .getResultStream()
                .map(department -> {
                    double max = department.getEmployees()
                            .stream()
                            .mapToDouble(employee -> employee.getSalary().doubleValue())
                            .max()
                            .orElse(0);
                    if (max < 30000 || max > 70000) {
                        return String.format("%s %.2f", department.getName(), max);
                    } else {
                        return "";
                    }
                })
                .filter(d -> !d.isEmpty())
                .collect(Collectors.joining("\n"));
        System.out.println(fromDepartment);
    }

    private static void ex11(EntityManager entityManager) throws IOException {
        entityManager.createQuery("FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')", Employee.class)
                .setParameter("letters", READER.readLine())
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary()));
    }

    private static void ex10(EntityManager entityManager) {
        List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.name IN " +
                "('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class).getResultList();

        for (Employee employee : resultList) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            entityManager.persist(employee);
            System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }

    }

    private static void ex9(EntityManager entityManager) {
        entityManager.createQuery("FROM Project ORDER BY startDate DESC, name", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(project -> System.out.printf("Project name: %s%n" +
                        "   Project Description: %s%n" +
                        "   Project Start Date: %s%n" +
                        "   Project End Date: %s%n", project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate()));
    }

    private static void ex8(EntityManager entityManager) throws IOException {
        Employee employee = entityManager.createQuery("FROM Employee e WHERE e.id = ?1", Employee.class)
                .setParameter(1, Integer.parseInt(READER.readLine()))
                .getSingleResult();
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(project -> System.out.printf("   %s%n", project.getName()));
    }

    private static void ex7(EntityManager entityManager) {
        entityManager.createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(address -> System.out.printf("%s, %s - %d employees%n",
                        address.getText(),
                        address.getTown().getName(),
                        address.getEmployees().size()));
    }

    private static void ex6(EntityManager entityManager) throws IOException {

        Town town = entityManager.find(Town.class, 32);

        Address address = new Address();
        address.setText("Vitoshka 15");
        address.setTown(town);

        entityManager.persist(address);


        String lastName = READER.readLine();

        List<Employee> resultList = entityManager.createQuery("FROM Employee WHERE lastName = :lastName", Employee.class).setParameter("lastName", lastName).getResultList();

        if (!resultList.isEmpty()) {
            Employee employee = resultList.get(0);
            employee.setAddress(address);
            entityManager.persist(employee);
        }
    }

    private static void ex5(EntityManager entityManager) {
        entityManager.createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.name = 'Research and Development' ORDER BY e.salary, e.id", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from Research and Development - %.2f%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));


    }

    private static void ex4(EntityManager entityManager) {
        entityManager.createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private static void ex3(EntityManager entityManager) {
        List<Town> resultList = entityManager.createQuery("FROM Town WHERE LENGTH(name) > 5", Town.class).getResultList();
        resultList.forEach(town -> {
            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        });
    }

    private static void ex2(EntityManager entityManager) throws IOException {
        String[] input = READER.readLine().split("\\s+");

        List<Employee> resultList = entityManager.createQuery("FROM Employee e WHERE firstName = :first_name AND lastName = :last_name", Employee.class)
                .setParameter("first_name", input[0])
                .setParameter("last_name", input[1])
                .getResultList();

        System.out.println(resultList.size() > 0 ? "yes" : "no");
    }
}
