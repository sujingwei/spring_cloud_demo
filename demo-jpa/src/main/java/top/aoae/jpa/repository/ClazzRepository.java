package top.aoae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aoae.jpa.domain.one2many.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
}
