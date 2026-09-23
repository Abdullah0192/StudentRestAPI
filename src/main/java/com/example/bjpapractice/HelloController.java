package com.example.bjpapractice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@RestController
public class HelloController {
    private final StudentService studentService;
    public HelloController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent){
        return studentService.updateStudent(id, updatedStudent);
    }
    @DeleteMapping("/students/{id}")
    public boolean deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
