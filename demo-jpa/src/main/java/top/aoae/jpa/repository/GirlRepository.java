package top.aoae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aoae.jpa.domain.one2one.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
}
