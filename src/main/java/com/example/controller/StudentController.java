/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import java.util.ArrayList;
import javax.validation.Valid;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Lenovo
 */



@RestController
@RequestMapping("/api/student/")
public class StudentController {
    
    Logger logger =getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    //@RequestMapping(value= "/get" , method = RequestMethod.GET)
    public List<StudentResponse> getAllStudent(){
        List<Student> studentList = studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @PostMapping("/create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student =studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }
    
    @PutMapping("/update")
    public StudentResponse updateStudent (@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }
    
    //@DeleteMapping("delete/{id}") and @PathVarible instead of @RequestParam
    @DeleteMapping("/delete")
    public String deleteStudent (@RequestParam long id){
        return studentService.deleteStudent(id);
    }
    
    @GetMapping("getByFirstName/{firstName}")
    public List<StudentResponse> getByFirstName (@PathVariable String firstName){
        List<Student> studentList =studentService.getByFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("getByLastName/{lastName}")
    public List<StudentResponse> getByLastName (@PathVariable String lastName){
        List<Student> studentList =studentService.getByLastName(lastName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName (@PathVariable String firstName,@PathVariable String lastName){
        
        return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
    }
    
    @GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstNameOrLastName (@PathVariable String firstName,@PathVariable String lastName){
        
        List<Student> studentList =studentService.getByFirstNameOrLastName(firstName,lastName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn (@RequestBody InQueryRequest inQueryRequest){
        
        //logger.info("inQueryRequest = " + inQueryRequest);
        List<Student> studentList =studentService.getByFirstNameIn(inQueryRequest);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        
        logger.info("studentResponseList = " + studentResponseList);
        return studentResponseList;
    }
    
    @GetMapping("getAllWithPagination")
    public List<StudentResponse> getAllWithPagination (@RequestParam int pageNo,@RequestParam int pageSize){
        
        List<Student> studentList =studentService.getAllWithPagination(pageNo,pageSize);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("getAllWithSorting")
    public List<StudentResponse> getAllWithSorting (){
        
        List<Student> studentList =studentService.getAllWithSorting();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("like/{firstName}")
    public List<StudentResponse> like (@PathVariable String firstName){
        
        List<Student> studentList =studentService.like(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("startsWith/{firstName}")
    public List<StudentResponse> startsWith (@PathVariable String firstName){
        
        List<Student> studentList =studentService.startsWith(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    
    @GetMapping("getByFirstNameAndLastName2/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName2 (@PathVariable String firstName,@PathVariable String lastName){
        
        return new StudentResponse(studentService.getByFirstNameAndLastName2(firstName, lastName));
    }
    
    @PutMapping("/updateEmail/{id}/{email}")
    public String updateStudentEmail (@PathVariable Long id,@PathVariable String email){
        return studentService.updateStudentEmail(id,email)+"Student is updated";
    }
    
    @GetMapping("/getByCity/{city}")
    public List<StudentResponse> getByCity(@PathVariable String city){
        List<Student> studentList =studentService.getByCity(city);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        
        studentList.stream().forEach(student -> {
        studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
}
