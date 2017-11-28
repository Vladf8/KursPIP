package hello;
import javax.persistence.*;

@Entity
@Table(name = "Свойство")
public class characteristic {
    @Column(name = "id")
    private int id;
    @Column(name = "Описание")
    private String description;
}
