package _1_;

import _1_.entities.*;
import _2_.PlateNumber;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inheritance");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        PlateNumber plateNumber = new PlateNumber("12345");

        Vehicle bike = new Bike("bmx", new BigDecimal(10), "none");
        Vehicle car = new Car("ford", new BigDecimal(100), "petrol", 5, plateNumber);
        Vehicle plane = new Plane("airbus", new BigDecimal(1000), "rakiq",50);
        Vehicle truck = new Truck("man", new BigDecimal(200), "diesel", 2000.0);

        entityManager.persist(plateNumber);
        entityManager.persist(bike);
        entityManager.persist(car);
        entityManager.persist(plane);
        entityManager.persist(truck);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
