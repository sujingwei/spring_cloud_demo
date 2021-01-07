package top.aoae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aoae.jpa.domain.one2one.Boy;

public interface BoyRepository extends JpaRepository<Boy, Integer> {

    /**
     * 动态命名
     * delete BOY from where girl_id=#{girl_id}
     * @return
     */
    public void deleteByGirlId(Integer id);
}
