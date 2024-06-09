/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.response;

import com.example.entity.Subject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Lenovo
 */
@Getter
@Setter
@ToString
public class SubjectResponse {
    
    private Long id;
    
    private String lecture_name;
    
    private Double score;
    
    public SubjectResponse(Subject subject){
        this.id=subject.getId();
        this.lecture_name=subject.getLecture_name();
        this.score=subject.getScore();
    }
}
