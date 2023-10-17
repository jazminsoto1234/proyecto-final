package com.example.demo.Group.domain;


import com.example.demo.Person.domain.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="grupo")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long  id;

    private String name;


    @ManyToMany(mappedBy = "groups")
    private Set<Person> persons;

    public Group(Long id, String name, Set<Person> persons){
        this.id = id;
        this.name = name;
        this.persons = persons;
    }

    public Group() {}

    public Long getId() {
        return this.id;
    }
    public String getname() {
        return this.name;
    }

    public Set<Person> getpersons() {
        return this.persons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setname(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        this.name =name;
    }

    public void Setpersons(Set<Person> persons) {

        this.persons =persons;
    }

}
