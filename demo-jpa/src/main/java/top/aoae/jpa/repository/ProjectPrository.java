package top.aoae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aoae.jpa.domain.many2many.Project;

public interface ProjectPrository extends JpaRepository<Project, Integer> {
}
