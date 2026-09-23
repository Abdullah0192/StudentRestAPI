package com.example.bjpapractice;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}


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
