package top.aoae.jpa.domain.one2many;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "t_clazz")
public class Clazz {

    public Clazz() {
    }

    public Clazz(Integer cid, String cname, List<Student> students) {
        this.cid = cid;
        this.cname = cname;
        this.students = students;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id")
    private Integer cid;

    @Column(name = "c_name", length = 255, columnDefinition = "")
    private String cname;

    /**
     * 一对多 默认是懒加载
     * mappedBy是用于映射一对多的关系，它的值是对象的属性，而不是数据表的字段
     */
    @OneToMany(mappedBy = "clz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students = null;

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
