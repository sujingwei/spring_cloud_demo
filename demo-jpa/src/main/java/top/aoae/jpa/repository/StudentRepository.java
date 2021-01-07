package top.aoae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aoae.jpa.domain.one2many.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
