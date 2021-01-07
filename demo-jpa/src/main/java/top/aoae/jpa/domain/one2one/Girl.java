package top.aoae.jpa.domain.one2one;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_girl")
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id")
    private Integer id;
    @Column(name = "g_name", length = 255)
    private String gname;

    @OneToOne(mappedBy = "girl")
    private Boy boy;

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                '}';
    }
}
