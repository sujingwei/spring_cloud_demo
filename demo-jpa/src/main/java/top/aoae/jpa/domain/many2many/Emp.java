package top.aoae.jpa.domain.many2many;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id")
    private Integer id;
    @Column(name = "n_name")
    private String nname;

    /**
     * mappedBy会放弃外键的关系维护，所以需要在多对多的另一方维护外键
     * todo 通过emp对象添加project对象是没有关联关系的，原因是因为：mappedBy会放弃外键的关系维护
     */
    @ManyToMany(mappedBy = "emps")
    private List<Project> projects = new ArrayList<>();

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", nname='" + nname + '\'' +
                '}';
    }
}
