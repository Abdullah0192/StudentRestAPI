package com.example.bjpapractice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class HelloController {
    private final StudentService studentService;
    public HelloController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students/search")
    public Page<StudentResponseDTO> getStudentsByName(@RequestParam String name, Pageable pageable){
        return studentService.searchStudentsByName(name, pageable);
    }
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> addStudentByDTO(@Valid @RequestBody StudentDTO studentDTO){
        StudentResponseDTO response = studentService.addStudentByDTO(studentDTO);
        return ResponseEntity.status(201).body(response);
//        return studentService.addStudentByDTO(studentDTO);
    }
    @GetMapping("/students/studentdto/{id}")
    public StudentDTO getStudentDTOById(@PathVariable Integer id){
        return studentService.getStudentDTOById(id);
    }
    @GetMapping("/students/studentdtos")
    public List<StudentDTO> getAllStudentDTOs(){
        return studentService.getAllStudentDTOs();
    }
    @GetMapping("/students/age/gThan/{age}")
    public List<Student> getStudentsByAgeGreaterThan(@PathVariable Integer age){
        return studentService.getStudentsByAgeGreaterThan(age);
    }
    @GetMapping("/students/age/lThan/{age}")
    public List<Student> getStudentsByAgeLessThan(@PathVariable Integer age){
        return studentService.getStudentsByAgeLessThan(age);
    }
    @GetMapping("/students/name/containing/{ch}")
    public List<Student> getStuddentsByNameContaining(@PathVariable String text){
        return studentService.getStudentsByNameContaining(text);
    }
    @GetMapping("/students/name/startingWith/{ch}")
    public List<Student> getStudentsByNameStartingWith(@PathVariable char ch){
        return studentService.getStudentsByNameStartingWith(ch);
    }
    @GetMapping("/students/name/{name}/age/{age}")
    public List<Student> getSTudentsByNameAndAge(@PathVariable String name,@PathVariable Integer age){
        return studentService.getStudentsByNameAndAge(name, age);
    }
    @GetMapping("/students/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable Integer age){
        return studentService.getStudentsByAge(age);
    }
    @GetMapping("/students")
    public Page<StudentResponseDTO> getAllStudentResponses(Pageable pageable){
        return studentService.getAllStudentResponses(pageable);
    }
    
    @GetMapping("/students/{id}")
    public StudentResponseDTO getStudentResponseDTOByIdById(@PathVariable int id){
        return studentService.getStudentResponseDTOById(id);
    }
    
//    @GetMapping("/students/{id}")
//    public Student getStudentById(@PathVariable int id){
//        return studentService.getStudentById(id);
//    }
//    @PostMapping("/students")
//    public Student addStudent(@RequestBody Student student){
//        return studentService.addStudent(student);
//    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentByDTO(@PathVariable int id,@Valid @RequestBody StudentDTO studentDTO){
        StudentResponseDTO response = studentService.updateStudentByDTO(id, studentDTO);
        return ResponseEntity.status(200).body(response);
    }
//    @PutMapping("/students/{id}")
//    public StudentResponseDTO updateStudentByDTO(@PathVariable int id,@Valid @RequestBody StudentDTO studentDTO){
//        return studentService.updateStudentByDTO(id, studentDTO);
//    }
//    @PutMapping("/students/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent){
//        return studentService.updateStudent(id, updatedStudent);
//    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
//    @DeleteMapping("/students/{id}")
//    public boolean deleteStudent(@PathVariable int id){
//        return studentService.deleteStudentById(id);
//    }
    @GetMapping("/students/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }
}
