/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Lenovo
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

     List<Student> findByFirstName(String firstName);
     List<Student> findByLastName(String lastName);
     Student findByFirstNameAndLastName(String firstName,String lastName);     
     List<Student> findByFirstNameOrLastName(String firstName,String lastName);     
     List<Student> findByFirstNameIn(List<String> firstNames);
     List<Student> findByFirstNameContains(String firstName);
     List<Student> findByFirstNameStartsWith(String firstName);
     
     @Query("From Student where firstName = :firstName and lastName =:lastName")
     Student getByFirstNameAndLastName(String firstName,String lastName);
     
     @Modifying
     @Transactional
     @Query("Update Student set firstName=:firstName where id =:id")
     Integer updateStudentEmail(Long id, String firstName);
     
     List<Student> findByAddressCity (String city);
     
     
     @Query("From Student where address.city=:city")
     List<Student> getByAddressCity (String city);

}
