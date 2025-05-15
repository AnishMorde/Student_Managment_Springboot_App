package com.studentManagment.StudentManagment.Repo;

import com.studentManagment.StudentManagment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
