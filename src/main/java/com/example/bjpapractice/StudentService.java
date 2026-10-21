package com.example.bjpapractice;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Page<StudentResponseDTO> getAllStudentResponses(Pageable pageable){
        Page<Student> students = studentRepository.findAll(pageable);
        return students.map(student -> convertToResponseDTO(student));
    }
    public Page<StudentResponseDTO> searchStudentsByName(String name, Pageable pageable){
        Page<Student> students = studentRepository.findByNameContaining(name, pageable);
        return students.map(student -> convertToResponseDTO(student));
    }
    public StudentResponseDTO convertToResponseDTO(Student student){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setAge(student.getAge());
        return studentResponseDTO;
    }
    
    public Student convertToEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }
    public StudentResponseDTO addStudentByDTO(StudentDTO studentDTO){
        Student student = convertToEntity(studentDTO);
        Student savedStudent = addStudent(student);
        return convertToResponseDTO(savedStudent);
    }
    public StudentDTO convertToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO(student.getName(), student.getAge());
//        studentDTO.setName(student.getName());
//        studentDTO.setAge(student.getAge());
        return studentDTO;
    }
    public StudentDTO getStudentDTOById(Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null){
            return null;
        }
        return convertToDTO(student);
    }
    public List<StudentDTO> getAllStudentDTOs(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs=  new ArrayList<>();
        for (Student student: students){
            studentDTOs.add(convertToDTO(student));
        }
        return studentDTOs;
    }
//    public List<StudentDTO> getAllStudentDTOs(){
//        List<StudentDTO> studentDTOs = new ArrayList<>();
//        for (Student student: studentRepository.findAll()){
//            studentDTOs.add(convertToDTO(student));
//        }
//        return studentDTOs;
//    }
//    public StudentDTO getStudentDTOById(Integer id ){
//        if (studentRepository.existsById(id)){
//            studentRepository.findById(id);
////            StudentDTO convertToDTO(Student ById(id));
////            Student student = new Student(id);
//            StudentDTO studentDTO = new StudentDTO(studentRepository.findByName(), student.findByAge());
////            return studentRepository.findById(id).orElse(null);
//        }
//        return null;
////        studentRepository.findById(id);
////        Student student = new StudentDTO(studentRepository.findByName(String name), studentRepository.findByAge(Integer age));
////        return student;
//    }
//    public StudentDTO getStudentDTOById(Integer id ){
//        if (studentRepository.existsById(id)){
//            Student student = new Student(id);
//            StudentDTO studentDTO = new StudentDTO(student.getName(), student.getAge());
//            return studentDTO;
//        }
//        return null;
////        studentRepository.findById(id);
////        Student student = new StudentDTO(studentRepository.findByName(String name), studentRepository.findByAge(Integer age));
////        return student;
//    }
    public List<Student> getStudentsByAgeGreaterThan(Integer age){
        return studentRepository.findByAgeGreaterThan(age);
    }
    public List<Student> getStudentsByAgeLessThan(Integer age){
        return studentRepository.findByAgeLessThan(age);
    }
    public List<Student> getStudentsByNameContaining(String text){
        return studentRepository.findByNameContaining(text);
    }
    public List<Student> getStudentsByNameStartingWith(char ch){
        return studentRepository.findByNameStartingWith(ch);
    }
    public List<Student> getStudentsByNameAndAge(String name, Integer age){
        return studentRepository.findByNameAndAge(name, age);
    }
    public List<Student> getStudentsByAge(Integer age){
        return studentRepository.findByAge(age);
    }
//    public List<Student> getAllStudents(){
//        return studentRepository.findAll();
//    }
    
    public List<StudentResponseDTO> getAllStudentResponses(){
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDTO> studentResponseDTOs = new ArrayList<>();
        for (Student student: students){
            studentResponseDTOs.add(convertToResponseDTO(student));
        }
        return studentResponseDTOs;
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student "+id+" not found"));
    }
    public StudentResponseDTO getStudentResponseDTOById(int id){
        Student student = getStudentById(id);
//        Student searched =  studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student "+id+" not found"));
        return convertToResponseDTO(student);
    }
//    public Student getStudentDTOById(int id){
//        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student "+id+" not found")); 
//    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(int id, Student student){
        Student toUpdate = getStudentById(id);
        toUpdate.setName(student.getName());
        toUpdate.setAge(student.getAge());
        return studentRepository.save(toUpdate);
    }
    public StudentResponseDTO updateStudentByDTO(int id, StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());       
        student.setAge(studentDTO.getAge());
        Student saved = updateStudent(id, student);
//        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
//        studentResponseDTO.setId(saved.getId());
//        studentResponseDTO.setName(saved.getName());
//        studentResponseDTO.setAge(saved.getAge());
        return convertToResponseDTO(saved);
    }
    public void deleteStudentById(int id){
        getStudentById(id);
//        Student student = getStudentById(id);
        studentRepository.deleteById(id);
    }
//    public boolean deleteStudent(int id){
//        if (studentRepository.existsById(id)){
//            studentRepository.deleteById(id);
//            return true;
//        }
//        return false;
////        return studentRepository.deleteStudent(id);
//    }
    public List<Student> getStudentByName(String name){
        return studentRepository.findByName(name);
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
