package hello;
import javax.persistence.*;

@Entity
@Table(name = "Битва")
public class battle {
    @Column(name = "id")
    private int id;
    @Column(name = "Дата")
    private String date;
}
