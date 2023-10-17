package com.example.demo.Group.application;

import com.example.demo.Group.domain.Group;
import com.example.demo.Group.services.GroupService;
import com.example.demo.Person.domain.Person;
import com.example.demo.Person.domain.PersonRepository;
import com.example.demo.Person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Group>> getGroups() {
        List<Group> group = groupService.findAllGroups();

        return ResponseEntity.status(200).body(group);
    }


    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody Group group) {
        Set<Person> getperson = group.getpersons();

        Set<Person> personas = new HashSet<>();
        for (Person per : getperson) {
            if (per != null) {
                personas.add(per);
                personService.savePerson(per);
            }
        }
        group.Setpersons(personas);
        groupService.saveGroup(group);
        return ResponseEntity.status(201).body("Created");
    }


    // GET: Recupera un curso por id
    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable Long id) {
        Optional<Group> group = groupService.findGroupById(id);
        Group grupo = group.get();
        return ResponseEntity.status(200).body(grupo);
    }


    // NUEVOS METODOS





    @GetMapping("/persons/{grupoId}")
    public ResponseEntity<List<Person>> getGroupsByPersonId(@PathVariable Long grupoId) {
        Set<Person> personfind = groupService.findGroupsPersons(grupoId);
        //Set<Group> groups = personfind.GetGroup();
        List<Person> persons = new ArrayList<>();
        for(Person per : personfind){
            persons.add(per);
        }

        return ResponseEntity.ok(persons);
    }

}