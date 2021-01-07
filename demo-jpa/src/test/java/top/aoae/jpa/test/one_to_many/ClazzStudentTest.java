package top.aoae.jpa.test.one_to_many;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aoae.jpa.JpaApplication;
import top.aoae.jpa.service.ClazzService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class ClazzStudentTest {

    @Autowired
    private ClazzService clazzService;

    @Test
    public void deleteClazzWithStudent() {
        clazzService.deleteClazzWithStu();
    }

}
