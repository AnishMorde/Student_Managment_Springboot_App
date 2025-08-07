package com.studentManagment.StudentManagment.Controller;


import com.studentManagment.StudentManagment.Entity.Student;
import com.studentManagment.StudentManagment.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@CrossOrigin(origins = "*")
public class StudentController {

private final StudentService studentService;

   public StudentController(StudentService studentService){
    this.studentService = studentService;
   }

   @PostMapping
   public ResponseEntity<Student> addStudent (@RequestBody Student student){
       return ResponseEntity.ok(studentService.addStudent(student));
   }


   @GetMapping
    public ResponseEntity<List<Student>> getAllStudents (){
       return ResponseEntity.ok(studentService.getAllStudent());
   }

   @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable Long id){
       return studentService.getStudentById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
   }

   @PutMapping("/{id}")
    public ResponseEntity<Student> uppdateStudent (@PathVariable Long id , @RequestBody Student student){
       return ResponseEntity.ok(studentService.updateStudent(id, student));
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent (@PathVariable Long id){
       studentService.deleteStudent(id);

       return ResponseEntity.noContent().build();
   }



}
