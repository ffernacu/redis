package pe.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.redis.model.Student;

import java.util.List;

@Repository
public interface StudentCrudRepository extends CrudRepository<Student, String> {
    List<Student> findByName(String name);
    List<Student> findByNameAndSurName(String name, String surName);
}
