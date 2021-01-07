package top.aoae.jpa.test.one_to_many;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aoae.jpa.JpaApplication;
import top.aoae.jpa.domain.many2many.Emp;
import top.aoae.jpa.domain.many2many.Project;
import top.aoae.jpa.repository.EmpRepository;
import top.aoae.jpa.repository.ProjectPrository;

import javax.swing.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class Many2ManyTest {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private ProjectPrository projectPrository;

    @Test
    public void initDB(){
        System.out.println("init ...");
    }

    @Test
    public void addEmp(){
        Emp emp = new Emp();
        emp.setNname("旺达");

        /**
         * 需然下面有project的信息，但是最终还是没有添加到数据表中
         * 因为 @ManyToMany(mappedBy = "emps") 在emp 表上
         * 通过 empRepository来进行添加操作的时候，不会维护对象的关联关系
         */
        Project project1 = new Project();
        project1.setPname("CRM");

        Project project2 = new Project();
        project2.setPname("ERP");

        emp.getProjects().add(project1);
        emp.getProjects().add(project2);

        empRepository.save(emp);
    }

    /**
     * 数据库里没有员工信息
     */
    @Test
    public void addProject(){
        Emp emp1 = new Emp();
        emp1.setNname("张三");

        Emp emp2 = new Emp();
        emp2.setNname("李四");

        Project project = new Project();
        project.setPname("CRM");
        project.getEmps().add(emp1);
        project.getEmps().add(emp2);

        // 直接添加会失败，
        // 原因是因为emp对象没有交给session管理

        // 方法一：
        empRepository.save(emp1);  // 如果emp1已存在表中，就不需要保存了
        empRepository.save(emp2);  // 如果emp2已存在表中，就不需要保存了

        projectPrository.save(project);
    }

    /**
     * 数据库里已经有了员工信息
     */
    @Test
    public void addProject2(){
        Project project = new Project();
        project.setPname("ERP");
        project.getEmps().add(empRepository.findById(2).get());
        project.getEmps().add(empRepository.findById(3).get());

        // 直接添加会失败，
        // 原因是因为emp对象没有交给session管理

        projectPrository.save(project);
    }

    @Test
    public void updateProject(){
        Project project = new Project();
        project.setId(4);
        project.setPname("bos");
        project.getEmps().add(empRepository.findById(1).get());
        project.getEmps().add(empRepository.findById(2).get());
        projectPrository.save(project);
    }

    @Test
    public void updateEmp(){
        Emp emp = new Emp();
        emp.setId(1);
        emp.setNname("小空");
        // 下面的操作是不会执行的，因为
        // @ManyToMany(mappedBy = "emps") 在emp 表上，放弃对外键的维护
        emp.getProjects().add(projectPrository.findById(3).get());
        empRepository.save(emp);
    }

    @Test
    public void findProject(){
        List<Project> all = projectPrository.findAll();
        for (Project p:all) {
            System.out.println(p.getId() + ", " + p.getPname());
            List<Emp> emps = p.getEmps();
            System.out.println(emps);
        }
    }

    @Test
    public void findEmp(){
        List<Emp> all = empRepository.findAll();
        for (Emp e:all) {
            System.out.println(e.getId() + ", " + e.getNname());

        }
    }

    @Test
    public void deleteProject(){
        // 会自动删除中间表的关系也删除
        projectPrository.deleteById(4);
    }

    @Test
    public void deleteEmp(){
        // 删除员工信息会失败，因为emp对象没有维护中间表
        // 删除之前需要先删除关联关系
        empRepository.deleteById(3);
    }


}
