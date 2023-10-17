package com.example.demo.Person.services;

import com.example.demo.Group.domain.Group;
import com.example.demo.Person.domain.Person;
import com.example.demo.Person.domain.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class  PersonService {
    //Implementar declaración de Repositorio
    @Autowired
    private PersonRepository personRepository;

    //Implementar metodo save Person
    public Person savePerson(Person  person){

        return  personRepository.save( person);
    }
    //Implementar metodo save Person
    public  Person  savePerson( Person  person ,Long id){
        Optional< Person> existe= personRepository.findById(id);
        if (existe.isPresent()){
            throw new RuntimeException("Ya existe un  Person con este ID");   }
        else{
            person.setId(id);
            return  personRepository.save( person);
        }

    }
    //Implementar metodo find PersonById
    public Optional< Person>  findPersonById(Long id){

        return  personRepository.findById(id);
    }

    //Implementar metodo findAll Persons
    public List< Person> findAllPersons(){

        return  personRepository.findAll();
    }

    //Implementar metodo update Person
    public  Person  updatePerson(Long id ,  Person  person ){
        Optional< Person> existePerson = personRepository.findById(id);
        if (existePerson.isPresent()){
            person.setId(id);
            return  personRepository.save( person);

        }
        return null;
    }


    public  Person  partialUpdatePerson(Long id ,  Person  person ){
        Optional<Person> existePerson=  personRepository.findById(id);
        if (existePerson.isPresent()){
            BeanUtils.copyProperties( person, existePerson.get(), "id");
            return personRepository.save(existePerson.get());

        }
        return null;
    }


    //Implementar metodo isEnrolledInAnyCourse---CAMBIE
    public boolean isEnrolledInAnyCourse(Long id ){
        Optional< Person>  PersonOptional =  personRepository.findById(id);
        if ( PersonOptional.isPresent()) {
            Person  person =  PersonOptional.get();
            return ! (person.GetGroup().isEmpty());
        }
        return false;
    }

    public Set<Group> findPersonsGroup(Long id){
        Optional<Person> PersonOptional = personRepository.findById(id);
        return PersonOptional.get().GetGroup();
    }


    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

}
