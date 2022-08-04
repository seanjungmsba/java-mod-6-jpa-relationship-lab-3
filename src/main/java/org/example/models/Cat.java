package org.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cat {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    private String breed;

    @ManyToMany(mappedBy = "cats")
    private List<Owner> owners = new ArrayList<>();

    public Cat() {
    }

    public Cat(int id, String name, int age, String breed, List<Owner> owners) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.owners = owners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", owners=" + owners +
                '}';
    }
}
