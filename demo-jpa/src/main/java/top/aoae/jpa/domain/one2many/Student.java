package top.aoae.jpa.domain.one2many;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_student")
public class Student {

    public Student() {
    }

    public Student(Integer id, String sname, Clazz clz) {
        this.id = id;
        this.sname = sname;
        this.clz = clz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id")

    private Integer id;
    @Column(name = "s_name", length = 255, columnDefinition = "")
    private String sname;

    /**
     * 多对一，一对多 默认是立即加载
     */
    @ManyToOne
    @JoinColumn(name = "c_id")  // 指定外键列
    private Clazz clz = null;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                '}';
    }
}
