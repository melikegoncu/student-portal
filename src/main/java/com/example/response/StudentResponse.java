/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.response;

import com.example.entity.Student;
import com.example.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;




/**
 *
 * @author Lenovo
 */

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentResponse {

    private long id;
    
    private String firstName;

    private String lastName;

    private String email;
    
    private String fullName;
    
    private String street;
    
    private String city;
    
    private List<SubjectResponse> learningSubjects;


    
    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.fullName = student.getFirstName() + " " + student.getLastName();
        
        if(student.getAddress().getStreet()!=null){
            this.street =student.getAddress().getStreet();
        }
        if(student.getAddress().getCity()!=null){
            this.city =student.getAddress().getCity();
        }
        
        if(student.getSubjects()!=null){
            learningSubjects=new ArrayList<>();
            student.getSubjects().forEach(subject -> {
                learningSubjects.add(new SubjectResponse(subject));
            });
        }
    }
}
