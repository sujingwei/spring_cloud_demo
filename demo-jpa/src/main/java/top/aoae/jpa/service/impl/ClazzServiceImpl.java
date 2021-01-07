package top.aoae.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aoae.jpa.domain.one2many.Clazz;
import top.aoae.jpa.domain.one2many.Student;
import top.aoae.jpa.repository.ClazzRepository;
import top.aoae.jpa.repository.StudentRepository;
import top.aoae.jpa.service.ClazzService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public void deleteClazzWithStu() {
        List<Clazz> clazzes = clazzRepository.findAll();
        for (Clazz clazz : clazzes) {
            // 一对多，多的一方是懒加载，当执行下面操作的时候，session关闭了
            // 所以执行下面操作会报No Session的错误
            List<Student> students = clazz.getStudents();
            for (Student student : students) {
                studentRepository.delete(student);
            }

            // 判断主外键连接
            // 删除所有的学生关联
            clazz.setStudents(null);
            clazzRepository.deleteById(clazz.getCid());
        }
    }
}
