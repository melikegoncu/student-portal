/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Lenovo
 */

//request payload infoları

@Getter
@Setter
public class CreateStudentRequest {
    @JsonProperty("first_name")
    @NotBlank(message = "First name is required")
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String street;
    
    private String city;
    
    private List<CreateSubjectRequest> subjects;
}
