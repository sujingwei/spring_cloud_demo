package top.aoae.jpa.test.one_to_many;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aoae.jpa.JpaApplication;
import top.aoae.jpa.domain.one2many.Clazz;
import top.aoae.jpa.domain.one2many.Student;
import top.aoae.jpa.repository.ClazzRepository;
import top.aoae.jpa.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class One2manyTest {
    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void initDB(){
        System.out.println("init db ...");
    }

    @Test
    public void addClazz(){
        Clazz clz = new Clazz(null, "夏至班", null);
        clazzRepository.save(clz);
        System.out.println(clz);
    }

    @Test
    public void updateClz(){
        Clazz clz = new Clazz(2, "元宵班", null);
        clazzRepository.save(clz);
    }

    @Test
    public void addStudent(){
        Student student = new Student();
        student.setSname("李四");
        student.setClz(new Clazz(1, null, null));
        studentRepository.save(student);
    }

    @Test
    public void updateStudent(){
        Student student = new Student(3, "李四", new Clazz(2, null, null));
        studentRepository.save(student);
    }

    /**
     * 查询所有的班级信息
     */
    @Test
    public void findClazz(){
        // 默认是懒加载，不查询学生信息
        List<Clazz> all = clazzRepository.findAll();
        for (Clazz clazz : all) {
            System.out.println(clazz.getCid() + " : "+ clazz.getCname()
                    // 只有我们要使用学生信息的时候，才会去查询
                    // + " : " + clazz.getStudents()
            );
        }
    }

    @Test
    public void findStudent(){
        // 默认是懒加载，不查询学生信息
        List<Student> all = studentRepository.findAll();
        for (Student stu: all) {
            System.out.println(stu.getId() + ", " + stu.getSname() + "，" + stu.getClz());
        }
    }

    @Test
    public void delClazz(){
        // 当前班级被其它表引用，所以没有办法删除
        // 方法一：
        // 配置，联级操作：@OneToMany(mappedBy = "clz", cascade = CascadeType.ALL)
        clazzRepository.deleteById(3);

        // 方法二：修改Student，让它和当前clazz不关联
    }

    @Test
    public void delStudent(){
        studentRepository.deleteById(1);
    }

    /**
     * 添加班级信息及学生信息
     */
    @Test
    public void add() {
        Clazz clz = new Clazz(null, "java高级就业班", null);
        List<Student> students = new ArrayList<>();
        students.add(new Student(null, "张三", clz));
        students.add(new Student(null, "李四", clz));
        clz.setStudents(students);
        clazzRepository.save(clz);
    }
}
