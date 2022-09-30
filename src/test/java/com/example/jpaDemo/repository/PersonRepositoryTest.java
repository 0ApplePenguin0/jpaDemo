package com.example.jpaDemo.repository;


import com.example.jpaDemo.JpaDemoApplicationTests;
import com.example.jpaDemo.model.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class PersonRepositoryTest extends JpaDemoApplicationTests {

    @Autowired
    private PersonRepository personRepository;



    @Test
    public void create(){
        Person p = new Person();
        p.setName("kee");
        p.setEmail("lee@naver.com");
        p.setCreateAt(LocalDateTime.now());
        p.setCreateBy("Test");

        System.out.println(p);
        personRepository.save(p);
    }


    @Test
    public void read(){
        Optional<Person> person = personRepository.findById(1);

        //Person p;
        person.ifPresent(p ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getEmail());
        });
    }

    //디버깅 (어디에.... 문제 발생 했을까? 찾아요..!!)
    //단위테스트 (내코드에 대한 확인이 있어! 이걸 증명하기 위해서)

    @Test
    public void read2(){
        Optional<Person> person = personRepository.findById(2);
   //    Assertions.assertTrue(person.isPresent());
        //Person p;
        person.ifPresent(p ->{
            System.out.println(p);
        });

        System.out.println("종료~!");
    }

    @Test
    //@Transactional
    public void update(){
        Optional<Person> person = personRepository.findById(2);
        person.ifPresent(p ->{
            p.setName("kkkkkkkkkkk");
            personRepository.save(p);
        });
    }
}
