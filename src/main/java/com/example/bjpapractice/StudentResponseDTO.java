/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bjpapractice;

public class StudentResponseDTO {
    private Integer id;
    private String name;
    private Integer age;
    public StudentResponseDTO(){
        
    }
    public StudentResponseDTO(Integer id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
}
