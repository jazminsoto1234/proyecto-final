package com.example.demo.Group.services;

import com.example.demo.Group.domain.Group;
import com.example.demo.Group.domain.GroupRepository;
import com.example.demo.Person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


//Aqui usaremos las herramientas de repository para manipular a la base de datos.
@Service
public class GroupService {

    //Inyeccion de dependencias degroupRepository
    @Autowired
    private GroupRepository groupRepository;


    private Person persona;


    public void saveGroup(Group group){
        groupRepository.save(group);
    }
    public List<Group> findAllGroups(){
        return groupRepository.findAll();
    }

    public Optional<Group> findGroupById(Long id) {
        return groupRepository.findById(id);
    }



    public Set<Person> findGroupsPersons(Long id){
        Optional<Group>GrupoOptional = groupRepository.findById(id);
        return GrupoOptional.get().getpersons();
    }

    public void deleteGroupById(Long id) {

        groupRepository.deleteById(id);
    }


}