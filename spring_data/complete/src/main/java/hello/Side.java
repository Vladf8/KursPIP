package hello;
import javax.persistence.*;

@Entity
@Table(name = "Сторона")
public class Side {
    @Column(name = "id_сторона")
    private int id_side;
    @Column(name = "Дата")
    private String date;
}
