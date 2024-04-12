package lab;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lab.inheritence.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("main");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        DemoVehicle car = new DemoCar("Fiesta", BigDecimal.valueOf(25000), "Diesel", 5);
        DemoVehicle bike = new DemoBike("H2R", BigDecimal.valueOf(30000), "Petrol");
        DemoVehicle truck = new DemoTruck("Scania", BigDecimal.valueOf(50000), "Diesel", 500000);
        DemoVehicle plane = new DemoPlane("Airbus", BigDecimal.valueOf(5000000), "plane-fuel", 300);

        entityManager.persist(car);
        entityManager.persist(bike);
        entityManager.persist(truck);
        entityManager.persist(plane);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
