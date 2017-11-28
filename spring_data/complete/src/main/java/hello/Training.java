package hello;
import javax.persistence.*;

@Entity
@Table(name = "Тренировка")
public class Training {
    @Column(name = "id")
    private int id;
    @Column(name = "Время")
    private String date;
}
