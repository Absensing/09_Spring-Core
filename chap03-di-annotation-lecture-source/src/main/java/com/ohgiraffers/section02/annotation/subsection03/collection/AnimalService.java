package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("animalCollection")
public class AnimalService {

    private List<Animal> animals;
    @Autowired
    public AnimalService(List<Animal> animals) {

        this.animals = animals;
    }

    public void animaleat() {
        for(Animal mm: animals){
            mm.eat();
        }
    }
}
