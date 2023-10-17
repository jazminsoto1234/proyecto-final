package com.example.demo.Person.domain;


import com.example.demo.Group.domain.Group;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


    @ManyToMany
    @JoinTable(
            name = "person_group",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>();

    //Crea un constructor vacío y uno con todos los atributos menos el id
    public Person(){};
    public  Person(String name, Set<Group> groups){
        this.name=name;
        this.groups=groups;
    }


    //Crea los getters y setters necesarios
    public void setName (String name ){
        this.name=name;

    }

    public String getName (){
        return name;

    }
    public void setGroups ( Set<Group> groups){

        this.groups=groups;

    }

    public Set<Group> GetGroup(){
        return this.groups;

    }


    //Funcion la cual agrega un curso al estudiante
    public void enrollInGroup(Group Group) {
        groups.add(Group);
        Group.getpersons().add(this);
    }
    public void setId (Long id  ){
        this.id=id;

    }

    public Long getId (){
        return id;

    }


}
