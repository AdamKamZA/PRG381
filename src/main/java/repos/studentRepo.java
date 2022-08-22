package repos;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Student;


public interface studentRepo extends JpaRepository<Student, Integer> {
    
}
