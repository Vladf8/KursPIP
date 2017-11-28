package hello;
import javax.persistence.*;


@Entity
@Table(name = "Земельный_надел")
public class Land {
    @Column(name = "Название")
    private String name;
}
