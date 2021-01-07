package top.aoae.jpa.test.one_to_many;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aoae.jpa.JpaApplication;
import top.aoae.jpa.domain.one2one.Boy;
import top.aoae.jpa.domain.one2one.Girl;
import top.aoae.jpa.repository.BoyRepository;
import top.aoae.jpa.repository.GirlRepository;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class One2OneTest {
    @Autowired
    private BoyRepository boyRepository;

    @Autowired
    private GirlRepository girlRepository;

    @Test
    public void initDB() {
        System.out.println("init ..");
    }

    @Test
    public void addGirl() {
        Girl girl = new Girl();
        girl.setGname("秋香");
        girlRepository.save(girl);
    }

    @Test
    public void addBoy() {
        Boy boy = new Boy();
        boy.setBname("唐伯虎");
        boy.setGirl(girlRepository.findById(1).get());
        boyRepository.save(boy);
    }

    @Test
    public void add() {
        Boy boy = new Boy();
        boy.setBname("黄晓明");

        Girl girl = new Girl();
        girl.setGname("Bady");

        boy.setGirl(girl);

        boyRepository.save(boy);
    }

    @Test
    public void findGrid() {
        Optional<Girl> grid = girlRepository.findById(2);
        System.out.println(grid);
    }

    @Test
    public void findBoy() {
        Boy boy = boyRepository.findById(1).get();
        System.out.println(boy);
        System.out.println(boy.getGirl());
    }

    @Test
    public void deleteGirl() {
        // 无法删除，要先删除关联关系
        girlRepository.deleteById(1);
    }

    @Test
    public void deleteBoy() {
        boyRepository.deleteById(2);
    }

}
