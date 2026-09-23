package com.example.bjpapractice;

import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(int id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }
    public boolean deleteStudent(int id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
//        return studentRepository.deleteStudent(id);
    }
    
}

//package com.example.bjpapractice;
//
//import java.util.List;
//import org.springframework.stereotype.Service;
//@Service
//public class StudentService {
//    private final StudentRepository studentRepository;
//    public StudentService(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    }
//    public List<Student> getAllStudents(){
//        return studentRepository.getAllStudents();
//    }
//    public Student getStudentById(int id){
//        return studentRepository.getStudentById(id);
//    }
//    public Student addStudent(Student student){
//        return studentRepository.addStudent(student);
//    }
//    public Student updateStudent(int id, Student student){
//        return studentRepository.updateStudent(id, student);
//    }
//    public boolean deleteStudent(int id){
//        return studentRepository.deleteStudent(id);
//    }
//    
//}
