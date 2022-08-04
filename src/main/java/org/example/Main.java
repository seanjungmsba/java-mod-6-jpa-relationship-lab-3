package org.example;

import org.example.models.Cat;
import org.example.models.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transactions
        transaction.begin();

        // create owners
        Owner owner1 = new Owner();
        owner1.setName("Owner A");

        Owner owner2 = new Owner();
        owner2.setName("Owner B");

        Owner owner3 = new Owner();
        owner3.setName("Owner C");

        // create cats
        Cat cat1 = new Cat();
        cat1.setName("Tori");
        cat1.setAge(5);
        cat1.setBreed("Savannah");

        Cat cat2 = new Cat();
        cat2.setName("Hoopsy");
        cat2.setAge(4);
        cat2.setBreed("Bengal");

        Cat cat3 = new Cat();
        cat3.setName("Sissy");
        cat3.setAge(2);
        cat3.setBreed("Siberian");

        // create students >-< subjects association
        List<Cat> cats = List.of(cat1, cat2, cat3);
        List<Owner> owners = List.of(owner1, owner2, owner3);

        owner1.setCats(cats);
        owner2.setCats(cats);
        owner3.setCats(cats);
        cat1.setOwners(owners);
        cat2.setOwners(owners);
        cat3.setOwners(owners);

        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(cat3);
        entityManager.persist(owner1);
        entityManager.persist(owner2);
        entityManager.persist(owner3);

        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}