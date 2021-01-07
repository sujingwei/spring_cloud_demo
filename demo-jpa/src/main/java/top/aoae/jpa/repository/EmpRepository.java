package top.aoae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aoae.jpa.domain.many2many.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
}
