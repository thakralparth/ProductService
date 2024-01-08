package com.productservice.productservice.inheritancerelations.tableperclass;

//import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    Student save(Student student);
}
