/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.service;

import com.example.entity.Address;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.StudentRepository;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.repository.AddressRepository;
import com.example.repository.SubjectRepository;
import com.example.request.CreateStudentRequest;
import com.example.request.CreateSubjectRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
/**
 *
 * @author Lenovo
 */
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    AddressRepository addressRepository;
    
    @Autowired
    SubjectRepository subjectRepository;

    public List<Student> getAllStudents (){
        return studentRepository.findAll();
    }
    
    public Student createStudent (CreateStudentRequest createStudentRequest){
        Student student =new Student(createStudentRequest);
        
        Address address =new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());
        
        address=addressRepository.save(address);
        student.setAddress(address);
        student = studentRepository.save(student);
        
        List<Subject> subjectList = new ArrayList<Subject>();
        
        if(createStudentRequest.getSubjects()!= null){
            for(CreateSubjectRequest createSubjectRequest : createStudentRequest.getSubjects()){
                Subject subject = new Subject();
                subject.setLecture_name(createSubjectRequest.getLecture_name());
                subject.setScore(createSubjectRequest.getScore());
                subject.setStudent(student);
                
                subjectList.add(subject);
            }
            subjectRepository.saveAll(subjectList);
        }
        
        student.setSubjects(subjectList);
        return student;
    }
    
    public Student updateStudent (UpdateStudentRequest updateStudentRequest){
        Student student= studentRepository.findById(updateStudentRequest.getId()).get();
        
        if(updateStudentRequest.getLastName() != null && !updateStudentRequest.getLastName().isEmpty()){
            student.setLastName(updateStudentRequest.getLastName());
        }
        
        student=studentRepository.save(student);
        
        return student;
    }
    
    public String deleteStudent (long id){
        studentRepository.deleteById(id);
        return "Student has been deleted succesfully";
    }
    
    public List<Student> getByFirstName (String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
    
    public List<Student> getByLastName (String lastName) {
        return studentRepository.findByLastName(lastName);
    }
    public Student getByFirstNameAndLastName (String firstName,String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }
    
    public List<Student> getByFirstNameOrLastName (String firstName,String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName,lastName);
    }
    
    public List<Student> getByFirstNameIn (InQueryRequest inQueryRequest) {
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }
    
    public List<Student> getAllWithPagination (int pageNo, int pageSize) {
        Pageable pageable =PageRequest.of(pageNo-1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }
    
    public List<Student> getAllWithSorting () {
        Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
        return studentRepository.findAll(sort);
    }
    
    public List<Student> like (String firstName) {
        return studentRepository.findByFirstNameContains(firstName);
    }
    
    public List<Student> startsWith (String firstName) {
        return studentRepository.findByFirstNameStartsWith(firstName);
    }
    
    public Student getByFirstNameAndLastName2 (String firstName,String lastName) {
        return studentRepository.getByFirstNameAndLastName(firstName,lastName);
    }
    
    public Integer updateStudentEmail (Long id,String email) {
        return studentRepository.updateStudentEmail(id, email);
    }
    
    public List<Student> getByCity (String city){
        return studentRepository.getByAddressCity(city);
    }
}
