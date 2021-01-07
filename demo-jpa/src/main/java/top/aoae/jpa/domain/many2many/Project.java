package top.aoae.jpa.domain.many2many;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id")
    private Integer id;
    @Column(name = "p_name")
    private String pname;

    /**
     * @JoinTable
     *  - name : 中间表的表名
     *  - uniqueConstraints : 指定联合主键
     *  - joinColumns ： 当前对象在中间表上维护的外键
     *      - name : 外键的数据表字段名称
     *      - referencedColumnName : 当前对象的属性名称
     *  - inverseJoinColumns : 关联对象在中间表上维护的外键关系
     *      - name :
     *      - referencedColumnName :
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_emp_project",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"emp_id", "project_id"})},
            joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "id")}
    )
    private List<Emp> emps = new ArrayList<>();

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                '}';
    }
}
