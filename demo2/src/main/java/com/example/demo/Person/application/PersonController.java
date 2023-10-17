package com.example.demo.Person.application;

import com.example.demo.Group.domain.Group;
import com.example.demo.Group.domain.GroupRepository;
import com.example.demo.Group.services.GroupService;
import com.example.demo.Person.domain.Person;
import com.example.demo.Person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupService groupService;

    // POST: Crea un nuevo curso
    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person person) {

        Set<Group> getgrupo = person.GetGroup();

        Set<Group> groups = new HashSet<>();
        for (Group groupId : getgrupo) {
                groups.add(groupId);
                groupService.saveGroup(groupId);

        }

        person.setGroups(groups);
        personService.savePerson(person);
        return ResponseEntity.status(201).body("Created");

    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Optional<Person> persona = personService.findPersonById(id);
        Person personaById = persona.get();
        return new ResponseEntity<>(personaById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAllPersons(), HttpStatus.OK);
    }


    // NUEVOS METODOS

    @GetMapping("/groups/{personId}")
    public ResponseEntity<List<Group>> getPersonsByGroupId(@PathVariable Long personId) {
        Set<Group> groups = personService.findPersonsGroup(personId);
        List<Group> grupos = new ArrayList<>();
        for(Group grup : groups){
            grupos.add(grup);
        }

        return ResponseEntity.ok(grupos);
    }

}