package com.example.bjpapractice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByName(String name);
    List<Student> findByAge(Integer age);
    List<Student> findByNameAndAge(String name, Integer age);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByNameContaining(String text);
    List<Student> findByNameStartingWith(char ch);
    Page<Student> findByNameContaining(String text, Pageable pageable);
}
//    Student student = new Student();
//    public String findByName(String name){
//        for (Student student: )
//        if (student.getName() == name){
//            return name;
//        }
//        return "Student not found";
//    }
//    public Student fndByNameAndAge(String name, int age){
//        
//    }
//    public String findByName(String name){
//        return 
//    }
//    public int findByAge(int age){
//        
//    }
    
//}


//package com.example.bjpapractice;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//import java.util.ArrayList;
//@Repository
//public class StudentRepository {
//    private final List<Student> students = new ArrayList<>();
//    public StudentRepository(){
//        students.add(new Student(1, "Abdullah", 21));
//        students.add(new Student(2, "Ali", 22));
//        students.add(new Student(3, "Comal", 23));
//    }
//    public List<Student> getAllStudents(){
//        return students;
//    }
//
//    public Student getStudentById(int id) {
//        for (Student student : students) {
//            if (student.getId() == id) {
//                return student;
//            }
//        }
//        return null;
//    }
//    public Student addStudent(Student student){
//        students.add(student);
//        return student;
//    }
//    public Student updateStudent(int id, Student updatedStudent){
//        for (int i=0; i<students.size(); i++){
//            if (students.get(i).getId() == id){
//                students.set(i, updatedStudent);
//                return updatedStudent;
//            }
//        }
//        return null;
//    }
//    public boolean deleteStudent(int id){
//        for (int i=0; i<students.size(); i++){
//            if (students.get(i).getId()== id){
//                students.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//}
