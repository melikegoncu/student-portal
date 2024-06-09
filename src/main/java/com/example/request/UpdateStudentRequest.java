/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lenovo
 */
@Getter
@Setter
public class UpdateStudentRequest {
    
    @NotNull
    private Long id;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
}
