package top.aoae.jpa.domain.one2one;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_boy")
public class Boy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id")
    private Integer id;
    @Column(name = "b_name", length = 255)
    private String bname;

    @OneToOne
    @JoinColumn(name = "girl_id", unique = true)
    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", bname='" + bname + '\'' +
                '}';
    }
}
