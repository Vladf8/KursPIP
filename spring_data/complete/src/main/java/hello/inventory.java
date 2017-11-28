package hello;
import javax.persistence.*;

@Entity
@Table(name = "Инвентарь")
public class inventory {
    @Column(name = "id")
    private int id;
    @Column(name = "Название")
    private String name;
}
