/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.entity;
import com.example.request.CreateStudentRequest;
import java.util.List;
import javax.persistence.CascadeType;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lenovo
 */
@Getter
@Setter
//@AllArgsConstructor
@Entity
@Table(name="student")
@NoArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
    
    @Transient
    private String fullName;
    
    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id",nullable = true)
    private Address address;
    
    @OneToMany(mappedBy="student")
    private List<Subject> subjects;
    
    public Student(CreateStudentRequest createStudentRequest){
        
        this.firstName = createStudentRequest.getFirstName();
        this.lastName = createStudentRequest.getLastName();        
        this.email = createStudentRequest.getEmail();
        this.fullName = createStudentRequest.getFirstName() + " " +
                createStudentRequest.getLastName();

    }
}
